package southday.mnrmp.mapper;

import java.util.List;

import southday.mnrmp.po.MnrmpDicData;

public interface MnrmpDicDataMapper {
	
	/**
	 * 根据lookupTypeCodeList来选择要取出的字典数据 <br>
	 * 即：<code> lookupTypeCode IN [lookupTypeCodeList] </code> 中的字典数据都会被取出
	 * @param lookupTypeCodeList
	 * @return
	 * @throws Exception
	 */
	public List<MnrmpDicData> findDicData(List<String> lookupTypeCodeList) throws Exception;
}
