package southday.mnrmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import southday.mnrmp.mapper.MnrmpCommonMapper;
import southday.mnrmp.mapper.MnrmpDicDataMapper;
import southday.mnrmp.mapper.MnrmpVideosTMapper;
import southday.mnrmp.po.MnrmpDicData;
import southday.mnrmp.po.MnrmpQueryParameter;
import southday.mnrmp.po.MnrmpVideoEx;
import southday.mnrmp.po.MnrmpVideosT;
import southday.mnrmp.service.MnrmpCommonService;

public class MnrmpCommonServiceImpl implements MnrmpCommonService {
	
	@Autowired
	private MnrmpCommonMapper commonMapper;
	
	@Autowired
	private MnrmpDicDataMapper dicDataMapper;

	@Override
	public List<MnrmpDicData> loadDicData(List<String> lookupTypeCodeList) throws Exception {
		// TODO Auto-generated method stub
		return dicDataMapper.findDicData(lookupTypeCodeList);
	}

	@Override
	public Integer nextAutoIncId(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return commonMapper.findNextAutoIncId(tableName);
	}
	
	@Autowired
	private MnrmpVideosTMapper videoMapper;

	@Override
	public List<MnrmpVideosT> loadHomePageVideos(MnrmpQueryParameter queryParam) throws Exception {
		// TODO Auto-generated method stub
		return videoMapper.findHomePageVideoRecord(queryParam);
	}

	@Override
	public Integer getVideoTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception {
		// TODO Auto-generated method stub
		return videoMapper.findHomePageVideoTotalRecordNum(queryParam);
	}

	@Override
	public MnrmpVideoEx getVideoInfoWithUser(MnrmpQueryParameter queryParam) throws Exception {
		// TODO Auto-generated method stub
		return videoMapper.findVideoExById(queryParam);
	}
	
}
