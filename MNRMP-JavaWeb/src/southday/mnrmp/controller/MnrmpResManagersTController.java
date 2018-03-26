package southday.mnrmp.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;

import southday.mnrmp.po.MnrmpAuditQueryResult;
import southday.mnrmp.po.MnrmpManagerAuditsT;
import southday.mnrmp.po.MnrmpQueryParameter;
import southday.mnrmp.po.MnrmpResManagersT;
import southday.mnrmp.po.MnrmpUserSessionT;
import southday.mnrmp.po.MnrmpVideoEx;
import southday.mnrmp.service.MnrmpCommonService;
import southday.mnrmp.service.MnrmpResManagersTService;
import southday.mnrmp.service.MnrmpUserSessionTService;
import southday.mnrmp.util.EncryptUtil;
import southday.mnrmp.util.MnrmpUtil;

@Controller
@RequestMapping("/resManager")
public class MnrmpResManagersTController {
    
    private static String[] commonPrivacyCodes = {
            "PUBLIC", "ENCRYPTION", "PRIVATE"
    };
    
    private static String[] commonStatusCodes = {
            "ACCEPTED", "REFUSED", "REVIEWING"
    };
    
    @Autowired
    private MnrmpResManagersTService resManagerService;
    
    @Autowired
    private MnrmpUserSessionTService userSessionService;
    
    @Autowired
    private MnrmpCommonService commonService;
    
    @RequestMapping("/login")
    public @ResponseBody MnrmpResManagersT login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 验证码是否正确
        String usrCaptchaResponse = request.getParameter("jcaptcha");
        boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, usrCaptchaResponse);
        if (!captchaPassed) {
            return null; // 前端通过判断object == null?来判断是不是验证码错误
        } 
        
        // 获取用户输入信息
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String userTypeCode = MnrmpUtil.USER_TYPE_RES_MANAGER;
        boolean rememberMe = Boolean.valueOf(request.getParameter("rememberMe"));
        // 填充 参数对象
        MnrmpResManagersT argResManager = new MnrmpResManagersT();
        argResManager.setAccount(account);
        argResManager.setPassword(EncryptUtil.getEncryptPassword(password));
        
        MnrmpResManagersT realResManager = resManagerService.login(argResManager);
        if (realResManager == null) {
            argResManager.setManagerId(null); // 前端通过判断Id == null?得知用户是否存在
            argResManager.setPassword(password); // 保密md5Password
            argResManager.setUserTypeCode(userTypeCode);
            argResManager.setHasLogined(false);
            return argResManager;
        } else {
            // 用户验证成功，将用户信息存入session
            realResManager.setUserTypeCode(userTypeCode);
            realResManager.setHasLogined(true);
            String currentSessionId = session.getId();
            session.setAttribute(currentSessionId, realResManager);
            MnrmpUtil.addSessionIdToUserSessionIdMap(realResManager, currentSessionId); // 为了实现不同浏览器(不同电脑)登录同一用户信息的同步
            if (rememberMe) {
                MnrmpUserSessionT userSession = new MnrmpUserSessionT();
                account = realResManager.getAccount(); // 当用户用的是[电子邮箱]登录时，要获取正确的account
                userSession.setAccount(account);
                userSession.setUserTypeCode(userTypeCode);
                userSession.setSessionId(currentSessionId);
                userSessionService.updateUserSessionId(userSession);
                // 创建cookie
                StringBuilder userLoginCookieValue = new StringBuilder(); // 取值时，使用','进行分割字符串
                userLoginCookieValue.append(realResManager.getManagerId()).append(",").append(account).append(",").append(currentSessionId).append(",").append(userTypeCode);
                Cookie userLoginCookie = new Cookie(MnrmpUtil.COOKIE_NAME_LOGIN_COOKIE, userLoginCookieValue.toString());
                userLoginCookie.setMaxAge(MnrmpUtil.COOKIE_SAVE_TIME);
                userLoginCookie.setPath(MnrmpUtil.LOGIN_COOKIE_PATH); // 整个项目目录都可使用该cookie
                response.addCookie(userLoginCookie);
            }
        }
        return realResManager;
    }
    
    @RequestMapping("/myAudits")
    public @ResponseBody MnrmpAuditQueryResult myAudits(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isResManager(session)) {
            return null;
        }
        fillQueryParam(session, queryParam);
        MnrmpAuditQueryResult auditQueryResult = new MnrmpAuditQueryResult();
        auditQueryResult.setAuditList(resManagerService.getAuditRecord(queryParam));
        auditQueryResult.setTotalRecordNum(resManagerService.getAuditTotalRecordNum(queryParam));
        return auditQueryResult;
    }
    
    @RequestMapping("/auditVideo")
    public @ResponseBody Boolean auditVideo(MnrmpManagerAuditsT managerAudit) throws Exception {
        managerAudit.setAuditDate(new Date());
        return resManagerService.auditVideo(managerAudit) ? false : true;
    }
    
    @RequestMapping("/updateBasicInfo")
    public @ResponseBody MnrmpResManagersT updateBasicInfo(HttpSession session, MnrmpResManagersT resManager) throws Exception {
        if (!isResManager(session)) {
            return null; // 说明当前登录者不是资源管理员
        }
        resManager.setManagerId(((MnrmpResManagersT) session.getAttribute(session.getId())).getManagerId());
        int beAffectedNum = resManagerService.updateResManagerBasicInfo(resManager);
        if (beAffectedNum == 0) {
            return null; // 说明修改用户基本信息失败
        }
        // 同步更新其他使用该用户账号登录系统的那些终端下账号信息
        MnrmpResManagersT realResManager = resManagerService.findResManagerById(resManager.getManagerId());
        MnrmpUtil.updateUserInfoInSession(session, realResManager);
        return realResManager;
    }
    
    @RequestMapping("/updatePassword")
    public @ResponseBody Boolean updatePassword(HttpSession session, HttpServletRequest request, MnrmpResManagersT resManager) throws Exception {
        if (!isResManager(session)) {
            return null; // 说明当前登录的账号不是资源管理员
        }
        String currentSessionId = session.getId();
        resManager.setManagerId(((MnrmpResManagersT) session.getAttribute(currentSessionId)).getManagerId());
        resManager.setPassword(EncryptUtil.getEncryptPassword(resManager.getPassword()));
        if (resManagerService.isPasswordRight(resManager)) {
            // 当输入的旧密码正确时才能更新密码
            String newPassword = request.getParameter("newPassword");
            resManager.setPassword(EncryptUtil.getEncryptPassword(newPassword));
            int beAffectedNum = resManagerService.updateResManagerPassword(resManager);
            if (beAffectedNum == 0) {
                return false; // 密码更新失败
            }
            // 更新密码后，要把除该终端下的其他所有使用该账号登录的终端的用户session清除，强制让它们重新登录
            MnrmpUtil.removeSessionByUser(session, resManager);
            // 因为上面的操作会删除该账号的所有session，所以这里需要重新把改session加入一遍
            MnrmpResManagersT realResManager = resManagerService.findResManagerById(resManager.getManagerId());
            session.setAttribute(currentSessionId, realResManager);
            MnrmpUtil.addSessionIdToUserSessionIdMap(realResManager, currentSessionId);
            return true;
        }
        return false; // 密码更新失败
    }
    
    @RequestMapping("/getVideo")
    public @ResponseBody MnrmpVideoEx getVideo(HttpSession session, MnrmpQueryParameter queryParam) throws Exception {
        if (!isResManager(session)) {
            return null;
        }
        queryParam.setManagerId(((MnrmpResManagersT) session.getAttribute(session.getId())).getManagerId());
        queryParam.setStatusCodes(commonStatusCodes);
        queryParam.setPrivacyCodes(commonPrivacyCodes);
        return commonService.getVideoInfoWithUser(queryParam);
    }
    
    /**
     * 判断session中保存的对象是否是资源管理员
     * @param session
     * @return
     */
    private boolean isResManager(HttpSession session) {
        Object obj = session.getAttribute(session.getId());
        return (obj instanceof MnrmpResManagersT) ? true : false;
    }
    
    /**
     * 填充 查询参数类对象中一些通用的参数值<br>
     * <p> [搜索关键字、资源管理员id、搜索记录数、搜索起始标号] </p>
     * @param session
     * @param queryParam
     */
    private void fillQueryParam(HttpSession session, MnrmpQueryParameter queryParam) {
        String searchKeyword = queryParam.getSearchKeyword();
        if (searchKeyword != null && searchKeyword.length() > 0) {
            queryParam.setSearchKeywords(searchKeyword.split(" {1,}"));
        }
        queryParam.setManagerId(((MnrmpResManagersT) session.getAttribute(session.getId())).getManagerId());
        queryParam.setSelectRecordNum(MnrmpUtil.SELECT_VIDEO_DEFAULT_NUM);
        queryParam.setStartRecordNo(queryParam.getSelectRecordNum() * (queryParam.getCurPageNo() - 1));
    }
}
