package southday.mnrmp.po;

import southday.mnrmp.util.MnrmpUtil;

/**
 * MNRMP 查询参数类
 * @author southday
 * @date Sep 22, 2016
 */
public class MnrmpQueryParameter {
	private String searchKeyword;
	
	private String[] searchKeywords;
	
	private String categoryCode;
	
	private Integer curPageNo = 1; // 当前页号 默认为第一页
	
	private Integer startRecordNo; // 数据库查询的起始记录标号
	
	private Integer selectRecordNum = MnrmpUtil.SELECT_VIDEO_DEFAULT_NUM; // 每次查询获取的记录条数
	
	private String privacyCode;
	
	private String[] privacyCodes;
	
	private String statusCode;
	
	private String[] statusCodes;
	
	private Integer managerId;
	
	private Integer userId;
	
	private Integer videoId;
	
	private Integer catalogId;
	
	private Integer replyId;
	
	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String[] getPrivacyCodes() {
		return privacyCodes;
	}

	public void setPrivacyCodes(String[] privacyCodes) {
		this.privacyCodes = privacyCodes;
	}

	public String[] getStatusCodes() {
		return statusCodes;
	}

	public void setStatusCodes(String[] statusCodes) {
		this.statusCodes = statusCodes;
	}

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword == null ? null : searchKeyword.trim();
	}

	public String[] getSearchKeywords() {
		return searchKeywords;
	}

	public void setSearchKeywords(String[] searchKeywords) {
		this.searchKeywords = searchKeywords;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode == null ? null : categoryCode.trim();
	}

	public Integer getCurPageNo() {
		return curPageNo;
	}

	public void setCurPageNo(Integer curPageNo) {
		this.curPageNo = curPageNo;
	}

	public Integer getStartRecordNo() {
		return startRecordNo;
	}

	public void setStartRecordNo(Integer startRecordNo) {
		this.startRecordNo = startRecordNo;
	}

	public Integer getSelectRecordNum() {
		return selectRecordNum;
	}

	public void setSelectRecordNum(Integer selectRecordNum) {
		this.selectRecordNum = selectRecordNum;
	}

	public String getPrivacyCode() {
		return privacyCode;
	}

	public void setPrivacyCode(String privacyCode) {
		this.privacyCode = privacyCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode == null ? null : statusCode.trim();
	}

}
