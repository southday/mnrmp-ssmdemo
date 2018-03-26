package southday.mnrmp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import southday.mnrmp.po.MnrmpProcReturnValue;
import southday.mnrmp.po.MnrmpQueryParameter;
import southday.mnrmp.po.MnrmpVideoEx;
import southday.mnrmp.po.MnrmpVideosT;

public interface MnrmpVideosTMapper {
	
	/**
	 * 根据id查询视频相信信息
	 * @param videoId
	 * @return
	 * @throws Exception
	 */
	public MnrmpVideosT findVideoById(@Param(value="videoId") Integer videoId) throws Exception;
	
    /**
     * 将视频记录插入到视频表中，并把初始的审核记录也插入到审核表中
     * @param videoEx
     * @return
     * @throws Exception
     */
	public MnrmpProcReturnValue insertVideoAndAuditRecord(MnrmpVideoEx videoEx) throws Exception;
	
	/**
	 * 根据查询参数类来确定要获取哪些记录
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public List<MnrmpVideosT> findHomePageVideoRecord(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 获取首页视频信息，在满足查询条件下的记录总数
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Integer findHomePageVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 根据videoId查询视频详细信息，包括用户名称
	 * @return
	 */
	public MnrmpVideoEx findVideoExById(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 根据上传者id和审核状态查询视频信息
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public List<MnrmpVideosT> findVideoByUserIdStatusCode(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 根据查询条件查询满足查询条件的上传记录总数
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Integer findUploadVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 根据用户id和视频id删除某个用户上传且已被拒绝的视频
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public MnrmpProcReturnValue deleteRefusedVideo(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 根据用户id，搜索关键字等查询用户的下载记录
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public List<MnrmpVideosT> findDownloadRecord(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 根据用户id，搜索关键字等查询用户下载的总记录数
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Integer findDownloadTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 根据用户id，搜索关键字等查询用户的收藏记录
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public List<MnrmpVideosT> findCollectRecord(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 根据用户id，搜索关键字等查询条件查询用户收藏总记录数
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Integer findCollectTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 根据用户id，搜索关键字等查询用户的点赞记录
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public List<MnrmpVideosT> findPraiseRecord(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 根据用户id，搜索关键字等查询条件查询用户点赞总记录数
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Integer findPraiseTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 查询某个用户的某个目录且仅是当前目录(不包含递归子目录)下的视频信息
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public List<MnrmpVideoEx> findVideoRecordJustCurCatalog(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 查询某个用户的某个目录且仅是当前目录(不包含递归子目录)下视频信息的总记录数
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Integer findVideoTotalRecordNumJustCurCatalog(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 查询某个用户的某个视频目录下的视频信息(含分页和搜索条件)
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public List<MnrmpVideoEx> findVideoRecordInSomeOneCatalog(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 查询某个用户的某个目录下满足查询条件的视频信息总数
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Integer findVideoTotalRecordNumInSomeOneCatalog(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 更新视频记录位置(视频文件移动)
	 * @param catalog
	 * @return
	 * @throws Exception
	 */
	public Boolean updateVideoSite(MnrmpVideosT video) throws Exception;
}