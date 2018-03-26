package southday.mnrmp.mapper;

import southday.mnrmp.po.MnrmpQueryParameter;

public interface MnrmpUserCollectsTMapper {
    
    /**
     * 插入用户收藏记录
     * @param queryParam
     * @return
     * @throws Exception
     */
    public Boolean insertCollectRecord(MnrmpQueryParameter queryParam) throws Exception;
}
