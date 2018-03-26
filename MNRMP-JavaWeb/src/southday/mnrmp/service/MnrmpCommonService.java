package southday.mnrmp.service;

import java.util.List;

import southday.mnrmp.po.MnrmpDicData;
import southday.mnrmp.po.MnrmpQueryParameter;
import southday.mnrmp.po.MnrmpVideoEx;
import southday.mnrmp.po.MnrmpVideosT;

/**
 * MNRMP 公共Service
 * @author southday
 * @date Sep 18, 2016
 */
public interface MnrmpCommonService {
    
    /**
     * 加载字典数据
     * @param lookupTypeCodeList
     * @return
     * @throws Exception
     */
    public List<MnrmpDicData> loadDicData(List<String> lookupTypeCodeList) throws Exception;
    
    /**
     * 返回指定表的下一个自增id
     * @return
     * @throws Exception
     */
    public Integer nextAutoIncId(String tableName) throws Exception;
    
    /**
     * 加载首页中的视频信息
     * @param queryParam
     * @return
     * @throws Exception
     */
    public List<MnrmpVideosT> loadHomePageVideos(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 获取首页加载的视频，在满足查询条件下的总记录数
     * @param queryParam
     * @return
     * @throws Exception
     */
    public Integer getVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
    
    /**
     * 根据videoId获取视频详细信息，包括用户名称
     * @param videoId
     * @return
     * @throws Exception
     */
    public MnrmpVideoEx getVideoInfoWithUser(MnrmpQueryParameter queryParam) throws Exception;
}
