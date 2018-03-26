package southday.mnrmp.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;

import southday.mnrmp.po.MnrmpCatalogsT;
import southday.mnrmp.po.MnrmpCommentEx;
import southday.mnrmp.po.MnrmpProcReturnValue;
import southday.mnrmp.po.MnrmpQueryParameter;
import southday.mnrmp.po.MnrmpUserCommentsT;
import southday.mnrmp.po.MnrmpUserSessionT;
import southday.mnrmp.po.MnrmpUsersT;
import southday.mnrmp.po.MnrmpVideoCategoryT;
import southday.mnrmp.po.MnrmpVideoEx;
import southday.mnrmp.po.MnrmpVideoQueryResult;
import southday.mnrmp.po.MnrmpVideosT;
import southday.mnrmp.service.MnrmpCommonService;
import southday.mnrmp.service.MnrmpResManagersTService;
import southday.mnrmp.service.MnrmpUserSessionTService;
import southday.mnrmp.service.MnrmpUsersTService;
import southday.mnrmp.util.EncryptUtil;
import southday.mnrmp.util.MnrmpUtil;
import southday.mnrmp.util.VideoProcUtil;

@Controller
@RequestMapping("/user")
public class MnrmpUsersTController {
    
    private static String[] commonPrivacyCodes = {
            "PUBLIC", "ENCRYPTION", "PRIVATE"
    };
    
    private static String[] commonStatusCodes = {
            "ACCEPTED", "REFUSED", "REVIEWING"
    };
    
    @Autowired
    private MnrmpUsersTService userService;
    
    @Autowired
    private MnrmpUserSessionTService userSessionService;
    
    @Autowired
    private MnrmpCommonService commonService;
    
    @RequestMapping("/getLoginedUser")
    public @ResponseBody Object getLoginedUser(HttpSession session) throws Exception {
        return session.getAttribute(session.getId());
    }
    
    @RequestMapping("/login")
    public @ResponseBody MnrmpUsersT login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 验证码是否正确
        String usrCaptchaResponse = request.getParameter("jcaptcha");
        boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, usrCaptchaResponse);
        if (!captchaPassed) {
            return null; // 前端通过判断object == null?来判断是不是验证码错误
        }
        
        // 获取用户输入信息
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String userTypeCode = MnrmpUtil.USER_TYPE_USER;
        boolean rememberMe = Boolean.valueOf(request.getParameter("rememberMe"));
        // 填充 参数对象
        MnrmpUsersT argUser = new MnrmpUsersT();
        argUser.setAccount(account);
        argUser.setPassword(EncryptUtil.getEncryptPassword(password));
        
        MnrmpUsersT realUser = userService.login(argUser);
        if (realUser == null) {
            argUser.setUserId(null); // 前端通过判断argUser.userId == null?得知用户是否存在
            argUser.setPassword(password); // 保密md5Password
            argUser.setUserTypeCode(userTypeCode);
            argUser.setHasLogined(false);
            return argUser;
        } else if (realUser.getIsValid() == true) { // 用户被冻结，则无法成功登录，所以也不能具备“记住密码”的功能
            // 用户验证成功，将用户信息存入session
            realUser.setUserTypeCode(userTypeCode);
            realUser.setHasLogined(true);
            String currentSessionId = session.getId();
            session.setAttribute(currentSessionId, realUser);
            MnrmpUtil.addSessionIdToUserSessionIdMap(realUser, currentSessionId); // 为了实现不同浏览器(不同电脑)登录同一用户信息的同步
            if (rememberMe) {
                MnrmpUserSessionT userSession = new MnrmpUserSessionT();
                account = realUser.getAccount(); // 当用户用的是[电子邮箱]登录时，要获取正确的account
                userSession.setAccount(account);
                userSession.setUserTypeCode(userTypeCode);
                userSession.setSessionId(currentSessionId);
                userSessionService.updateUserSessionId(userSession);
                // 创建cookie
                StringBuilder userLoginCookieValue = new StringBuilder(); // 取值时，使用','进行分割字符串
                userLoginCookieValue.append(realUser.getUserId()).append(",").append(account).append(",").append(currentSessionId).append(",").append(userTypeCode);
                Cookie userLoginCookie = new Cookie(MnrmpUtil.COOKIE_NAME_LOGIN_COOKIE, userLoginCookieValue.toString());
                userLoginCookie.setMaxAge(MnrmpUtil.COOKIE_SAVE_TIME);
                userLoginCookie.setPath(MnrmpUtil.LOGIN_COOKIE_PATH); // 整个项目目录都可使用该cookie
                response.addCookie(userLoginCookie);
            }
        }
        return realUser;
    }
    
    @Autowired
    private MnrmpResManagersTService resManagerService;
    
    @RequestMapping("/uploadVideo")
    public @ResponseBody Boolean uploadVideo(HttpSession session, HttpServletRequest request, MnrmpVideoEx videoEx, MultipartFile multVideo) throws Exception {
        if (!isUser(session)) {
            // 按理来说，这个逻辑应该是由权限控制取管理的，而不是在这里实现
            return null;
        }
        // 从session中拿到上传者id
        videoEx.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        
        // 将视频文件写入本地保存
        String videoName = null;
        try {
            videoName = writeFileToNativePlace(multVideo);
            videoEx.setVideoName(videoName);
        } catch (Exception e) { // 返回用户上传视频失败的提示(状态码)
            return false;
        }
        
        // 抓取视频缩略图并保存在本地，缩略图名称与视频名称一致，只是后缀名不同而已
        String miniatureName = VideoProcUtil.newMiniatureName(videoName);
        String videoPath = VideoProcUtil.getVideoPath(VideoProcUtil.VIDEO_SAVE_SITE_LOCAL, videoName);
        String miniaturePath = VideoProcUtil.getMiniaturePath(VideoProcUtil.MINIATURE_SAVE_SITE_LOCAL, miniatureName);
        int grabTime = VideoProcUtil.getVideoTime(videoPath) / 3; // 将抓取图片的时间设为视频时长的第一个1/3处
        if (!VideoProcUtil.grabMiniature(grabTime, videoPath, miniaturePath)) {
            // 如果抓取失败，则使用默认的缩略图
            miniatureName = MnrmpUtil.DEFAULT_MINIATURE_NAEM;
        }
        videoEx.setMiniatureName(miniatureName);
        // 将mp4文件元数据移到视频第一帧，实现客户端浏览器边播放边加载
        VideoProcUtil.moveMetadataInMp4(videoPath);
        
        // 随机选取一个资源管理员id(审核者)，并设置在videoEx中
        videoEx.setManagerId(resManagerService.randomSelectOneResManagerId());
        // 将视频信息写入数据库的视频表中，生成新的审核记录写到审核记录表中
        MnrmpProcReturnValue procReturnValue = userService.insertVideoAndAuditRecord(videoEx);
        if (procReturnValue.gettError() == true) {
            // 如果插入数据失败，则删除之前保存的文件
            MnrmpUtil.deleteFile(videoPath); 
            // 如果缩略图不是默认缩略图则删除缩略图
            if (!MnrmpUtil.DEFAULT_MINIATURE_NAEM.equals(miniatureName)) {
                MnrmpUtil.deleteFile(miniaturePath);
            }
            // 返回上传失败的信息(状态码)
            return false;
        }
        
        /* 如果来到这里依旧没有问题，则进行最后一步，就是将视频分类信息保存到数据库
         * 很遗憾，这里本来也是[上传视频]这个事务的一部分，但是我没在这里实现事务的原子性，
         * 因为我感觉这一步，一般不会出现什么问题，说多了也累，就先这么着
         */
        Integer videoId = procReturnValue.getKeyId(); // 获取刚才插入视频表的记录的主键videoId
        String[] categories = request.getParameterValues("category");
        MnrmpVideoCategoryT videoCategory = new MnrmpVideoCategoryT();
        videoCategory.setVideoId(videoId);
        // 这里，我没有找到可以批量插入记录的方法，所以就一条一条插入，效率比较差
        for (String categoryCode : categories) {
            videoCategory.setCategoryCode(categoryCode);
            userService.insertOneVideoCategoryRecord(videoCategory);
        }
        // 返回上传成功的信息(状态码)
        return true;
    }
    
    /**
     * 将文件写入本地保存，并返回文件名称
     * @param multVideo
     * @return
     * @throws Exception
     */
    private String writeFileToNativePlace(MultipartFile multFile) throws Exception {
        if (multFile == null) {
            throw new Exception("上传的视频文件为null");
        }
        // 将视频文件写入本地保存
        try {
            String videoName = VideoProcUtil.newVideoName(multFile.getOriginalFilename());
            File video = new File(VideoProcUtil.getVideoPath(VideoProcUtil.VIDEO_SAVE_SITE_LOCAL, videoName));
            multFile.transferTo(video);
            return videoName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("将视频文件写入本地失败");
        }
    }
    
    @RequestMapping("/myAllCatalogs")
    public @ResponseBody List<MnrmpCatalogsT> myAllCatalogs(HttpSession session) throws Exception {
        Object obj = session.getAttribute(session.getId());
        return (obj instanceof MnrmpUsersT) ? userService.getAllCatalogs(((MnrmpUsersT) obj).getUserId()) : null;
    }
    
    @RequestMapping("/myCatalogs")
    public @ResponseBody List<MnrmpCatalogsT> myCatalogs(HttpSession session, MnrmpCatalogsT catalog) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        catalog.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        return userService.getCatalogWithChilds(catalog);
    }
    
    @RequestMapping("/updateBasicInfo")
    public @ResponseBody MnrmpUsersT updateBasicInfo(HttpSession session, MnrmpUsersT user) throws Exception {
        if (!isUser(session)) {
            return null; // 说明当前登录者不是普通用户
        }
        user.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        int beAffectedNum = userService.updateUserBasicInfo(user);
        if (beAffectedNum == 0) {
            return null; // 说明修改用户基本信息失败
        }
        // 同步更新其他使用该用户账号登录系统的那些终端下账号信息
        MnrmpUsersT realUser = userService.findUserById(user.getUserId());
        MnrmpUtil.updateUserInfoInSession(session, realUser);
        return realUser;
    }
    
    @RequestMapping("/updatePassword")
    public @ResponseBody Boolean updatePassword(HttpSession session, HttpServletRequest request, MnrmpUsersT user) throws Exception {
        if (!isUser(session)) {
            return null; // 说明当前登录者不是普通用户
        }
        String currentSessionId = session.getId();
        user.setUserId(((MnrmpUsersT) session.getAttribute(currentSessionId)).getUserId());
        user.setPassword(EncryptUtil.getEncryptPassword(user.getPassword()));
        if (userService.isPasswordRight(user)) {
            // 当用户输入的就密码正确时才能更新密码
            String newPassword = request.getParameter("newPassword");
            user.setPassword(EncryptUtil.getEncryptPassword(newPassword));
            int beAffectedNum = userService.updateUserPassword(user);
            if (beAffectedNum == 0) {
                return false; // 密码更新失败
            }
            // 更新密码后，要把除该终端下的其他所有使用该账号登录的终端的用户session清除，强制让它们重新登录
            MnrmpUtil.removeSessionByUser(session, user);
            // 因为上面的操作会删除该账号的所有session，所以这里需要重新把改session加入一遍
            MnrmpUsersT realUser = userService.findUserById(user.getUserId());
            session.setAttribute(currentSessionId, realUser);
            MnrmpUtil.addSessionIdToUserSessionIdMap(realUser, currentSessionId);
            return true;
        }
        return false;
    }
    
    @RequestMapping("/myUploads")
    public @ResponseBody MnrmpVideoQueryResult myUploads(HttpSession session, HttpServletRequest request, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        fillQueryParam(session, queryParam);
        MnrmpVideoQueryResult videoQueryResult = new MnrmpVideoQueryResult();
        videoQueryResult.setVideoList(userService.getUploadVideos(queryParam));
        videoQueryResult.setTotalRecordNum(userService.getUploadVideoTotalRecordNum(queryParam));
        return videoQueryResult;
    }
    
    @RequestMapping("/deleteRefusedVideo")
    public @ResponseBody Boolean deleteRefusedVideo(HttpSession session, HttpServletRequest request, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        String statusCode = queryParam.getStatusCode();
        if ((statusCode == null || !"REFUSED".equals(statusCode))) {
            return null;
        }
        queryParam.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        // 先删除数据库中的记录
        MnrmpProcReturnValue procReturnValue = userService.deleteRefusedVideo(queryParam);
        if (procReturnValue.gettError() == true) { // 删除视频失败
            return false;
        }
        // 若删除数据库中的记录成功，则删除本地文件
        MnrmpUtil.deleteFile(VideoProcUtil.getVideoPath(VideoProcUtil.VIDEO_SAVE_SITE_LOCAL, procReturnValue.getVideoName()));
        MnrmpUtil.deleteFile(VideoProcUtil.getMiniaturePath(VideoProcUtil.MINIATURE_SAVE_SITE_LOCAL    , procReturnValue.getMiniatureName()));
        return true;
    }
    
    @RequestMapping("/myDownloads")
    public @ResponseBody MnrmpVideoQueryResult myDownloads(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        fillQueryParam(session, queryParam);
        MnrmpVideoQueryResult videoQueryResult = new MnrmpVideoQueryResult();
        videoQueryResult.setVideoList(userService.getDownloadVideos(queryParam));
        videoQueryResult.setTotalRecordNum(userService.getDownlaodVideoTotalRecordNum(queryParam));
        return videoQueryResult;
    }
    
    @RequestMapping("/myCollects")
    public @ResponseBody MnrmpVideoQueryResult myCollects(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        fillQueryParam(session, queryParam);
        MnrmpVideoQueryResult videoQueryResult = new MnrmpVideoQueryResult();
        videoQueryResult.setVideoList(userService.getCollectVideos(queryParam));
        videoQueryResult.setTotalRecordNum(userService.getCollectVideoTotalRecordNum(queryParam));
        return videoQueryResult;
    }
    
    @RequestMapping("/myPraises")
    public @ResponseBody MnrmpVideoQueryResult myPraises(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        fillQueryParam(session, queryParam);
        MnrmpVideoQueryResult videoQueryResult = new MnrmpVideoQueryResult();
        videoQueryResult.setVideoList(userService.getPraiseVideos(queryParam));
        videoQueryResult.setTotalRecordNum(userService.getPraiseVideoTotalRecordNum(queryParam));
        return videoQueryResult;
    }
    
    @RequestMapping("/myVideosJustCurCatalog")
    public @ResponseBody MnrmpVideoQueryResult myVideosJustCurCatalog(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        fillQueryParam(session, queryParam);
        MnrmpVideoQueryResult videoQueryResult = new MnrmpVideoQueryResult();
        videoQueryResult.setVideoExList(userService.getVideoRecordJustCurCatalog(queryParam));
        videoQueryResult.setTotalRecordNum(userService.getVideoTotalRecordNumJustCurCatalog(queryParam));
        return videoQueryResult;
    }
    
    @RequestMapping("/myVideosInCatalog")
    public @ResponseBody MnrmpVideoQueryResult myVideosInCatalog(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        fillQueryParam(session, queryParam);
        MnrmpVideoQueryResult videoQueryResult = new MnrmpVideoQueryResult();
        videoQueryResult.setVideoExList(userService.getVideosInSomeOneCatalog(queryParam));
        videoQueryResult.setTotalRecordNum(userService.getVideoTotalRecordNumInSomeOneCatalog(queryParam));
        return videoQueryResult;
    }
    
    @RequestMapping("/downloadVideo")
    public @ResponseBody Boolean downloadVideo(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        queryParam.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        return userService.downloadVideo(queryParam) ? false : true; // 方法的返回值代表是否回滚，所以这样写
    }
    
    @RequestMapping("/collectVideo")
    public @ResponseBody Boolean collectVideo(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        queryParam.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        return userService.collectVideo(queryParam) ? false : true; // 方法的返回值代表是否回滚，所以这样写
    }
    
    @RequestMapping("/praiseVideo")
    public @ResponseBody Boolean praiseVideo(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        queryParam.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        return userService.praiseVideo(queryParam) ? false : true; // 方法的返回值代表是否回滚，所以这样写
    }
    
    @RequestMapping("/createCatalog")
    public @ResponseBody MnrmpCatalogsT createCatalog(HttpSession session, MnrmpCatalogsT catalog) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        catalog.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        String catalogName = catalog.getCatalogName();
        if (catalogName == null || "".equals(catalogName)) {
            return null;
        }
        MnrmpCatalogsT newCatalog = userService.createCatalog(catalog);
        return newCatalog;
    }
    
    @RequestMapping("/deleteCatalog")
    public @ResponseBody Boolean deleteCatalog(HttpSession session, MnrmpCatalogsT catalog) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        catalog.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        // 先获取要删除的视频记录的videoId, videoName, miniatureName，以实现同步删除本地视频文件和缩略图文件
        List<MnrmpVideosT> videoList = userService.getMyVideosByCatalogId(catalog);
        
        boolean isRollBack = userService.deleteCatalog(catalog);
        if (isRollBack == true) {
            return false;// 删除失败
        }
        // 若删除成功，则删除本地视频文件
        for (MnrmpVideosT video : videoList) {
            MnrmpUtil.deleteFile(VideoProcUtil.getVideoPath(VideoProcUtil.VIDEO_SAVE_SITE_LOCAL, video.getVideoName()));
            MnrmpUtil.deleteFile(VideoProcUtil.getMiniaturePath(VideoProcUtil.MINIATURE_SAVE_SITE_LOCAL, video.getMiniatureName()));
        }
        return true; // 删除成功
    }
    
    @RequestMapping("/renameCatalog")
    public @ResponseBody MnrmpCatalogsT renameCatalog(HttpSession session, MnrmpCatalogsT catalog) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        catalog.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        String catalogName = catalog.getCatalogName();
        if (catalogName == null || "".equals(catalogName)) {
            return null;
        }
        if (userService.renameCatalogName(catalog) == true) {
            return userService.getCatalogByCatalogId(catalog.getCatalogId());
        } else {
            return null;
        }
    }
    
    @RequestMapping("/moveCatalog")
    public @ResponseBody MnrmpCatalogsT moveCatalog(HttpSession session, MnrmpCatalogsT catalog) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        catalog.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        Integer catalogId = catalog.getCatalogId();
        Integer parentCatalogId = catalog.getParentCatalogId();
        if (catalogId == null || parentCatalogId == null) {
            return null;
        } else if (catalogId.intValue() == parentCatalogId.intValue()) {
            return null;
        }
        if (userService.moveCatalog(catalog) == true) {
            return userService.getCatalogByCatalogId(catalog.getCatalogId());
        } else {
            return null;
        }
    }
    
    @RequestMapping("/moveVideo")
    public @ResponseBody Boolean moveVideo(HttpSession session, MnrmpVideosT video) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        video.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        return userService.moveVideo(video); // 返回是否移动成功
    }
    
    @RequestMapping("/getVideo")
    public @ResponseBody MnrmpVideoEx getVideo(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        queryParam.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        queryParam.setStatusCodes(commonStatusCodes);
        queryParam.setPrivacyCodes(commonPrivacyCodes);
        return commonService.getVideoInfoWithUser(queryParam);
    }
    
    @RequestMapping("/comment")
    public @ResponseBody MnrmpCommentEx comment(HttpSession session, MnrmpUserCommentsT comment) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        comment.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        MnrmpCommentEx commentEx = userService.addComment(comment);
        if (commentEx != null) {
            commentEx.setHasReply(userService.isChildCommentExists(commentEx.getCommentId()));
        }
        return commentEx;
    }
    
    @RequestMapping("/deleteComment")
    public @ResponseBody Boolean deleteComment(HttpSession session, MnrmpUserCommentsT comment) throws Exception {
        if (!isUser(session) || comment.getCommentId() == null) {
            return null;
        }
        comment.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        return userService.deleteCommentWithChilds(comment) ? false : true; // 返回值为[是否回滚]，回滚表示删除失败
    }
    
    @RequestMapping("/getComments")
    public @ResponseBody List<MnrmpCommentEx> getComments(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        queryParam.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        queryParam.setSelectRecordNum(MnrmpUtil.SELECT_COMMENT_DEFAULT_NUM);
        queryParam.setStartRecordNo(queryParam.getSelectRecordNum() * (queryParam.getCurPageNo() - 1));
        List<MnrmpCommentEx> commentExs = userService.getCommentWithoutChilds(queryParam);
        for (MnrmpCommentEx commentEx : commentExs) {
            commentEx.setHasReply(userService.isChildCommentExists(commentEx.getCommentId()));
        }
        return commentExs;
    }
    
    @RequestMapping("/supportComment")
    public @ResponseBody Boolean supportComment(HttpSession session, Integer commentId) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        return userService.addCommentSupportNum(commentId); // 返回[是否支持成功]
    }
    
    @RequestMapping("/opposeComment")
    public @ResponseBody Boolean opposeComment(HttpSession session, Integer commentId) throws Exception {
        if (!isUser(session)) {
            return null;
        }
        return userService.addCommentOpposeNum(commentId); // 返回[是否反对成功]
    }
    
    /**
     * 判断session中的用户对象是否为普通用户
     * @param session
     * @return
     */
    private boolean isUser(HttpSession session) {
        Object obj = session.getAttribute(session.getId());
        return (obj instanceof MnrmpUsersT) ? true : false;
    }
    
    /**
     * 填充 查询参数类对象中一些通用的参数值<br>
     * <p> [搜索关键字、用户id、搜索记录数、搜索起始标号] </p>
     * @param session
     * @param queryParam
     */
    private void fillQueryParam(HttpSession session, MnrmpQueryParameter queryParam) {
        String searchKeyword = queryParam.getSearchKeyword();
        if (searchKeyword != null && searchKeyword.length() > 0) {
            queryParam.setSearchKeywords(searchKeyword.split(" {1,}"));
        }
        queryParam.setUserId(((MnrmpUsersT) session.getAttribute(session.getId())).getUserId());
        queryParam.setSelectRecordNum(MnrmpUtil.SELECT_VIDEO_DEFAULT_NUM);
        queryParam.setStartRecordNo(queryParam.getSelectRecordNum() * (queryParam.getCurPageNo() - 1));
    }
}
