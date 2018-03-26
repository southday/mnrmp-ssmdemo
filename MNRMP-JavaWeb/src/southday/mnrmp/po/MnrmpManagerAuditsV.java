package southday.mnrmp.po;

import java.util.Date;

/**
 * 资源管理员审核vo
 * @author southday
 * @date Sep 22, 2016
 */
public class MnrmpManagerAuditsV extends MnrmpManagerAuditsT {
	private String videoTitle;
	
	private String videoName;
	
	private String miniatureName;
	
	private Date uploadDate;
	
	private Integer userId;
	
	private String userName;

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getMiniatureName() {
		return miniatureName;
	}

	public void setMiniatureName(String miniatureName) {
		this.miniatureName = miniatureName;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
