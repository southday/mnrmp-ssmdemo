package southday.mnrmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import southday.mnrmp.mapper.MnrmpCatalogsTMapper;
import southday.mnrmp.mapper.MnrmpUserCollectsTMapper;
import southday.mnrmp.mapper.MnrmpUserCommentsTMapper;
import southday.mnrmp.mapper.MnrmpUserDownloadsTMapper;
import southday.mnrmp.mapper.MnrmpUserPraisesTMapper;
import southday.mnrmp.mapper.MnrmpUsersTMapper;
import southday.mnrmp.mapper.MnrmpVideoCategoryTMapper;
import southday.mnrmp.mapper.MnrmpVideosTMapper;
import southday.mnrmp.po.MnrmpCatalogsT;
import southday.mnrmp.po.MnrmpCommentEx;
import southday.mnrmp.po.MnrmpProcReturnValue;
import southday.mnrmp.po.MnrmpQueryParameter;
import southday.mnrmp.po.MnrmpUserCommentsT;
import southday.mnrmp.po.MnrmpUsersT;
import southday.mnrmp.po.MnrmpVideoCategoryT;
import southday.mnrmp.po.MnrmpVideoEx;
import southday.mnrmp.po.MnrmpVideosT;
import southday.mnrmp.service.MnrmpUsersTService;

public class MnrmpUsersTServiceImpl implements MnrmpUsersTService {
    
    @Autowired
    private MnrmpUsersTMapper userMapper;

    @Override
    public MnrmpUsersT login(MnrmpUsersT user) throws Exception {
        // TODO Auto-generated method stub
        if (user.getAccount().contains("@")) {
            user.setEmail(user.getAccount()); // 使用 [电子邮箱] 登录
            return userMapper.findUserByEmailPassword(user);
        } else { // 使用 [登录账号] 登录
            return userMapper.findUserByAccountPassword(user);
        }
    }

    @Override
    public MnrmpUsersT findUserByAccount(String account) throws Exception {
        // TODO Auto-generated method stub
        return userMapper.findUserByAccount(account);
    }

    @Override
    public Boolean isAccountExists(String account) throws Exception {
        // TODO Auto-generated method stub
        return userMapper.findAccountExists(account);
    }

    @Override
    public Boolean isEmailExists(String email) throws Exception {
        // TODO Auto-generated method stub
        return userMapper.findEmailExists(email);
    }

    @Override
    public Boolean register(MnrmpUsersT user) throws Exception {
        // TODO Auto-generated method stub
        return userMapper.insertUser(user);
    }

    @Override
    public Boolean isUserHasActivated(Integer userId) throws Exception {
        // TODO Auto-generated method stub
        return userMapper.findIsActivatedByUserId(userId);
    }

    @Override
    public Integer activateUser(MnrmpUsersT user) throws Exception {
        // TODO Auto-generated method stub
        return userMapper.updateIsActivatedByUserId(user);
    }
    
    @Autowired
    private MnrmpCatalogsTMapper catalogMapper;

    @Override
    public List<MnrmpCatalogsT> getAllCatalogs(Integer userId) throws Exception {
        // TODO Auto-generated method stub
        return catalogMapper.findCatalogsByUserId(userId);
    }

    @Autowired
    private MnrmpVideoCategoryTMapper videoCategoryMapper;
    
    @Override
    public void insertOneVideoCategoryRecord(MnrmpVideoCategoryT videoCategory) throws Exception {
        // TODO Auto-generated method stub
        videoCategoryMapper.insertOneVideoCategoryRecord(videoCategory);
    }
    
    @Autowired
    private MnrmpVideosTMapper videoMapper;

    @Override
    public MnrmpProcReturnValue insertVideoAndAuditRecord(MnrmpVideoEx videoEx) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.insertVideoAndAuditRecord(videoEx);
    }

    @Override
    public Integer updateUserBasicInfo(MnrmpUsersT user) throws Exception {
        // TODO Auto-generated method stub
        return userMapper.updateUserById(user);
    }

    @Override
    public Integer updateUserPassword(MnrmpUsersT user) throws Exception {
        // TODO Auto-generated method stub
        return userMapper.updateUserPasswordById(user);
    }

    @Override
    public MnrmpUsersT findUserById(Integer userId) throws Exception {
        // TODO Auto-generated method stub
        return userMapper.findUserById(userId);
    }

    @Override
    public Boolean isPasswordRight(MnrmpUsersT user) throws Exception {
        // TODO Auto-generated method stub
        return userMapper.findUserExistsByIdPassword(user);
    }
    
    @Override
    public List<MnrmpVideosT> getUploadVideos(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findVideoByUserIdStatusCode(queryParam);
    }

    @Override
    public Integer getUploadVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findUploadVideoTotalRecordNum(queryParam);
    }

    @Override
    public MnrmpProcReturnValue deleteRefusedVideo(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.deleteRefusedVideo(queryParam);
    }

    @Override
    public List<MnrmpVideosT> getDownloadVideos(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findDownloadRecord(queryParam);
    }

    @Override
    public Integer getDownlaodVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findDownloadTotalRecordNum(queryParam);
    }

    @Override
    public List<MnrmpVideosT> getCollectVideos(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findCollectRecord(queryParam);
    }

    @Override
    public Integer getCollectVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findCollectTotalRecordNum(queryParam);
    }

    @Override
    public List<MnrmpVideosT> getPraiseVideos(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findCollectRecord(queryParam);
    }

    @Override
    public Integer getPraiseVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findCollectTotalRecordNum(queryParam);
    }

    @Override
    public List<MnrmpVideoEx> getVideosInSomeOneCatalog(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findVideoRecordInSomeOneCatalog(queryParam);
    }

    @Override
    public Integer getVideoTotalRecordNumInSomeOneCatalog(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findVideoTotalRecordNumInSomeOneCatalog(queryParam);
    }

    @Autowired
    private MnrmpUserDownloadsTMapper userDownloadsMapper;
    
    @Override
    public Boolean downloadVideo(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return userDownloadsMapper.insertDownloadRecord(queryParam);
    }
    
    @Autowired
    private MnrmpUserCollectsTMapper userCollectsMapper;

    @Override
    public Boolean collectVideo(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return userCollectsMapper.insertCollectRecord(queryParam);
    }
    
    @Autowired
    private MnrmpUserPraisesTMapper userPraisesMapper;

    @Override
    public Boolean praiseVideo(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return userPraisesMapper.insertPraiseRecord(queryParam);
    }
    
    @Override
    public MnrmpCatalogsT createCatalog(MnrmpCatalogsT catalog) throws Exception {
        // TODO Auto-generated method stub
        return catalogMapper.insertCatalog(catalog);
    }

    @Override
    public List<MnrmpVideosT> getMyVideosByCatalogId(MnrmpCatalogsT catalog) throws Exception {
        // TODO Auto-generated method stub
        return catalogMapper.findMyVideosByCatalogId(catalog);
    }

    @Override
    public Boolean deleteCatalog(MnrmpCatalogsT catalog) throws Exception {
        // TODO Auto-generated method stub
        return catalogMapper.deleteCatalog(catalog);
    }

    @Override
    public Boolean renameCatalogName(MnrmpCatalogsT catalog) throws Exception {
        // TODO Auto-generated method stub
        return catalogMapper.updateCatalogName(catalog);
    }

    @Override
    public Boolean moveCatalog(MnrmpCatalogsT catalog) throws Exception {
        // TODO Auto-generated method stub
        return catalogMapper.updateCatalogSite(catalog);
    }

    @Override
    public Boolean moveVideo(MnrmpVideosT video) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.updateVideoSite(video);
    }

    @Override
    public List<MnrmpCatalogsT> getCatalogWithChilds(MnrmpCatalogsT catalog) throws Exception {
        // TODO Auto-generated method stub
        return catalogMapper.findCatalogWithChilds(catalog);
    }

    @Override
    public MnrmpCatalogsT getCatalogByCatalogId(Integer catalogId) throws Exception {
        // TODO Auto-generated method stub
        return catalogMapper.findCatalogByCatalogId(catalogId);
    }

    @Override
    public List<MnrmpVideoEx> getVideoRecordJustCurCatalog(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findVideoRecordJustCurCatalog(queryParam);
    }

    @Override
    public Integer getVideoTotalRecordNumJustCurCatalog(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return videoMapper.findVideoTotalRecordNumJustCurCatalog(queryParam);
    }
    
    @Autowired
    private MnrmpUserCommentsTMapper commentMapper;

    @Override
    public MnrmpCommentEx addComment(MnrmpUserCommentsT comment) throws Exception {
        // TODO Auto-generated method stub
        return commentMapper.insertComment(comment);
    }

    @Override
    public Boolean deleteCommentWithChilds(MnrmpUserCommentsT comment) throws Exception {
        // TODO Auto-generated method stub
        return commentMapper.deleteCommentWithChilds(comment);
    }

    @Override
    public List<MnrmpCommentEx> getCommentWithoutChilds(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return commentMapper.findCommentWithoutChilds(queryParam);
    }

    @Override
    public Boolean isChildCommentExists(Integer commentId) throws Exception {
        // TODO Auto-generated method stub
        return commentMapper.findChildCommentIsExists(commentId);
    }

    @Override
    public Boolean addCommentSupportNum(Integer commentId) throws Exception {
        // TODO Auto-generated method stub
        return commentMapper.updateCommentSupportNum(commentId);
    }

    @Override
    public Boolean addCommentOpposeNum(Integer commentId) throws Exception {
        // TODO Auto-generated method stub
        return commentMapper.updateCommentOpposeNum(commentId);
    }
    
}
