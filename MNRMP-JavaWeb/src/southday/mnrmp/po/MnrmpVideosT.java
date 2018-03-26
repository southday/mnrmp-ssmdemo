package southday.mnrmp.po;

import java.util.Date;

public class MnrmpVideosT {
    private Integer videoId;

    private String videoTitle;

    private String videoName;

    private String statusCode;

    private Integer userId;

    private Date uploadDate;

    private Integer catalogId;

    private Integer praisedNum;

    private Integer downloadNum;

    private Integer collectedNum;

    private String intro;

    private String miniatureName;

    private String privacyCode;

    private String seePassword;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode == null ? null : statusCode.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getPraisedNum() {
        return praisedNum;
    }

    public void setPraisedNum(Integer praisedNum) {
        this.praisedNum = praisedNum;
    }

    public Integer getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(Integer downloadNum) {
        this.downloadNum = downloadNum;
    }

    public Integer getCollectedNum() {
        return collectedNum;
    }

    public void setCollectedNum(Integer collectedNum) {
        this.collectedNum = collectedNum;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getMiniatureName() {
        return miniatureName;
    }

    public void setMiniatureName(String miniatureName) {
        this.miniatureName = miniatureName == null ? null : miniatureName.trim();
    }

    public String getPrivacyCode() {
        return privacyCode;
    }

    public void setPrivacyCode(String privacyCode) {
        this.privacyCode = privacyCode == null ? null : privacyCode.trim();
    }

    public String getSeePassword() {
        return seePassword;
    }

    public void setSeePassword(String seePassword) {
        this.seePassword = seePassword == null ? null : seePassword.trim();
    }
}
