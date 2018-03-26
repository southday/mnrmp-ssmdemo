package southday.mnrmp.service;

import java.util.List;

import southday.mnrmp.po.MnrmpCatalogsT;
import southday.mnrmp.po.MnrmpCommentEx;
import southday.mnrmp.po.MnrmpProcReturnValue;
import southday.mnrmp.po.MnrmpQueryParameter;
import southday.mnrmp.po.MnrmpUserCommentsT;
import southday.mnrmp.po.MnrmpUsersT;
import southday.mnrmp.po.MnrmpVideoCategoryT;
import southday.mnrmp.po.MnrmpVideoEx;
import southday.mnrmp.po.MnrmpVideosT;

public interface MnrmpUsersTService {
    
    /**
     * 用户登录
     * @param user
     * @return
     * @throws Exception
     */
    public MnrmpUsersT login(MnrmpUsersT user) throws Exception;
    
    /**
     * 根据用户账号查找用户信息并返回
     * @param account
     * @return
     * @throws Exception
     */
    public MnrmpUsersT findUserByAccount(String account) throws Exception;
    
    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     * @throws Exception
     */
    public MnrmpUsersT findUserById(Integer userId) throws Exception;
    
    /**
     * 用户密码是否正确
     * @param user
     * @return
     * @throws Exception
     */
    public Boolean isPasswordRight(MnrmpUsersT user) throws Exception;
    
    /**
     * 判断用户账号是否已经存在
     * @param account
     * @return
     * @throws Exception
     */
    public Boolean isAccountExists(String account) throws Exception;
    
    /**
     * 判断用户电子邮箱是否已经存在
     * @param email
     * @return
     * @throws Exception
     */
    public Boolean isEmailExists(String email) throws Exception;
    
    /**
     * 用户注册
     * @param user
     * @return
     * @throws Exception
     */
    public Boolean register(MnrmpUsersT user) throws Exception;
    
    /**
     * 判断用户是否已经激活
     * @param userId
     * @return
     * @throws Exception
     */
    public Boolean isUserHasActivated(Integer userId) throws Exception;
    
    /**
     * 激活用户账号
     * @param User
     * @throws Exception
     */
    public Integer activateUser(MnrmpUsersT user) throws Exception;
    
    /**
     * 返回指定用户的视频目录
     * @param userId
     * @return
     * @throws Exception
     */
    public List<MnrmpCatalogsT> getAllCatalogs(Integer userId) throws Exception;
    
    /**
     * 插入一条视频分类记录
     * @param vieoCategory
     * @throws Exception
     */
    public void insertOneVideoCategoryRecord(MnrmpVideoCategoryT videoCategory) throws Exception;
    
    /**
     * 将视频记录插入到视频表中，并把初始的审核记录也插入到审核表中
     * @param videoEx
     * @return
     * @throws Exception
     */
    public MnrmpProcReturnValue insertVideoAndAuditRecord(MnrmpVideoEx videoEx) throws Exception;
    
    /**
     * 更新用户基本信息
     * @param user
     * @return
     * @throws Exception
     */
    public Integer updateUserBasicInfo(MnrmpUsersT user) throws Exception;
    
    /**
     * 修改用户密码
     * @param user
     * @return
     * @throws Exception
     */
    public Integer updateUserPassword(MnrmpUsersT user) throws Exception; 
    
    /**
     * 获取上传的视频
     * @param queryParam
     * @return
     * @throws Exception
     */
    public List<MnrmpVideosT> getUploadVideos(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 返回满足查询条件的上传记录总数
     * @param queryParam
     * @return
     * @throws Exception
     */
    public Integer getUploadVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 删除某用户上传的已被拒绝的视频
     * @param queryParam
     * @return
     * @throws Exception
     */
    public MnrmpProcReturnValue deleteRefusedVideo(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 获取用户下载记录
     * @param queryParam
     * @return
     * @throws Exception
     */
    public List<MnrmpVideosT> getDownloadVideos(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 返回满足查询条件的用户下载记录总数
     * @param queryParam
     * @return
     * @throws Exception
     */
    public Integer getDownlaodVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 获取用户收藏记录
     * @param queryParam
     * @return
     * @throws Exception
     */
    public List<MnrmpVideosT> getCollectVideos(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 返回满足查询条件的用户收藏记录总数
     * @param queryParam
     * @return
     * @throws Exception
     */
    public Integer getCollectVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 获取用户点赞记录
     * @param queryParam
     * @return
     * @throws Exception
     */
    public List<MnrmpVideosT> getPraiseVideos(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 返回满足查询条件的用户点赞记录总数
     * @param queryParam
     * @return
     * @throws Exception
     */
    public Integer getPraiseVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 获取某个用户的某个目录且仅是当前目录(不包含递归子目录)下的视频信息
     * @param queryParam
     * @return
     * @throws Exception
     */
    public List<MnrmpVideoEx> getVideoRecordJustCurCatalog(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 获取某个用户的某个目录且仅是当前目录(不包含递归子目录)下视频信息的总记录数
     * @param queryParam
     * @return
     * @throws Exception
     */
    public Integer getVideoTotalRecordNumJustCurCatalog(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 获取某个用户的某个目录下的满足查询条件的视频信息
     * @param queryParam
     * @return
     * @throws Exception
     */
    public List<MnrmpVideoEx> getVideosInSomeOneCatalog(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 返回满足查询条件的某个用户的某个目录下的视频总记录数
     * @param queryParam
     * @return
     * @throws Exception
     */
    public Integer getVideoTotalRecordNumInSomeOneCatalog(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 用户下载视频
     * @param queryParam
     * @return
     * @throws Exception
     */
    public Boolean downloadVideo(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 用户收藏视频
     * @param queryParam
     * @return
     * @throws Exception
     */
    public Boolean collectVideo(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 用户点赞视频 / 用户取消视频点赞
     * @param queryParam
     * @return
     * @throws Exception
     */
    public Boolean praiseVideo(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 新建视频目录
     * @param catalog
     * @return
     * @throws Exception
     */
    public MnrmpCatalogsT createCatalog(MnrmpCatalogsT catalog) throws Exception;
    
    /**
     * 在删除视频目录前，获取该用户自己上传的[已接受]或[已拒绝]的在该目录下的视频信息
     * @param catalog
     * @return
     * @throws Exception
     */
    public List<MnrmpVideosT> getMyVideosByCatalogId(MnrmpCatalogsT catalog) throws Exception;
    
    /**
     * 删除视频目录(会把该视频目录下的所有视频记录清空)
     * @param catalog
     * @return
     * @throws Exception
     */
    public Boolean deleteCatalog(MnrmpCatalogsT catalog) throws Exception;
    
    /**
     * 视频目录重命名
     * @param catalog
     * @return
     * @throws Exception
     */
    public Boolean renameCatalogName(MnrmpCatalogsT catalog) throws Exception;
    
    /**
     * 视频目录移动
     * @param catalog
     * @return
     * @throws Exception
     */
    public Boolean moveCatalog(MnrmpCatalogsT catalog) throws Exception;
    
    /**
     * 视频记录移动
     * @param catalog
     * @return
     * @throws Exception
     */
    public Boolean moveVideo(MnrmpVideosT video) throws Exception;
    
    /**
     * 获取指定用户的某个目录及其所有子目录的信息
     * @param catalog
     * @return
     * @throws Exception
     */
    public List<MnrmpCatalogsT> getCatalogWithChilds(MnrmpCatalogsT catalog) throws Exception;
    
    /**
     * 根据catalogId获取视频目录信息
     * @param catalogId
     * @return
     * @throws Exception
     */
    public MnrmpCatalogsT getCatalogByCatalogId(Integer catalogId) throws Exception;
    
    /**
     * 添加评论，若添加成功则返回所添加的资料
     * @param comment
     * @return
     * @throws Exception
     */
    public MnrmpCommentEx addComment(MnrmpUserCommentsT comment) throws Exception;
    
    /**
     * 删除评论，级联删除该评论下的所有子评论
     * @param comment
     * @return
     * @throws Exception
     */
    public Boolean deleteCommentWithChilds(MnrmpUserCommentsT comment) throws Exception;
    
    /**
     * 获取一定数量的评论，但不获取这些评论的子评论
     * @param queryParam
     * @return
     * @throws Exception
     */
    public List<MnrmpCommentEx> getCommentWithoutChilds(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 判断某个评论是否存在子评论
     * @param commentId
     * @return
     * @throws Exception
     */
    public Boolean isChildCommentExists(Integer commentId) throws Exception;
    
    /**
     * 增加评论被支持数量 + 1
     * @param commentId
     * @return
     * @throws Exception
     */
    public Boolean addCommentSupportNum(Integer commentId) throws Exception;
    
    /**
     * 增加评论被反对数量 + 1
     * @param commentId
     * @return
     * @throws Exception
     */
    public Boolean addCommentOpposeNum(Integer commentId) throws Exception;
}
