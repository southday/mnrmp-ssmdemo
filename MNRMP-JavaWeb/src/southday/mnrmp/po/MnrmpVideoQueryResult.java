package southday.mnrmp.po;

import java.util.List;

/**
 * 用来包装与视频信息查询有关的查询结果
 * @author southday
 * @date Sep 24, 2016
 */
public class MnrmpVideoQueryResult {
	private List<MnrmpVideosT> videoList;
	
	private Integer totalRecordNum;
	
	private List<MnrmpVideoEx> videoExList;
	
	public List<MnrmpVideoEx> getVideoExList() {
		return videoExList;
	}

	public void setVideoExList(List<MnrmpVideoEx> videoExList) {
		this.videoExList = videoExList;
	}

	public List<MnrmpVideosT> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<MnrmpVideosT> videoList) {
		this.videoList = videoList;
	}

	public Integer getTotalRecordNum() {
		return totalRecordNum;
	}

	public void setTotalRecordNum(Integer totalRecordNum) {
		this.totalRecordNum = totalRecordNum;
	}
	
}
