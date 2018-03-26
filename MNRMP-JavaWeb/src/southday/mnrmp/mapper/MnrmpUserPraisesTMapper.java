package southday.mnrmp.mapper;

import southday.mnrmp.po.MnrmpQueryParameter;

public interface MnrmpUserPraisesTMapper {
    
	/**
	 * 插入用户点赞记录
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Boolean insertPraiseRecord(MnrmpQueryParameter queryParam) throws Exception;
}