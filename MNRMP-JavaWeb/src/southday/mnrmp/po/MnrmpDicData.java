package southday.mnrmp.po;

import java.util.List;

/**
 * MNRMP 字典数据类 - 封装类
 * @author southday
 * @date Sep 18, 2016
 */
public class MnrmpDicData extends MnrmpLookupTypesT {
	private List<MnrmpLookupValuesT> lookupValueList;

	public List<MnrmpLookupValuesT> getLookupValueList() {
		return lookupValueList;
	}

	public void setLookupValueList(List<MnrmpLookupValuesT> lookupValueList) {
		this.lookupValueList = lookupValueList;
	}
}
