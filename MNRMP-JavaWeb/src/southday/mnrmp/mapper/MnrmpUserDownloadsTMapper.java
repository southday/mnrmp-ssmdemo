package southday.mnrmp.mapper;

import southday.mnrmp.po.MnrmpQueryParameter;

public interface MnrmpUserDownloadsTMapper {
	
	/**
	 * 插入用户下载记录
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Boolean insertDownloadRecord(MnrmpQueryParameter queryParam) throws Exception;
    
}