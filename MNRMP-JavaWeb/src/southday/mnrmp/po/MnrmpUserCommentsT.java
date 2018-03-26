package southday.mnrmp.po;

import java.util.Date;

public class MnrmpUserCommentsT {
    private Integer commentId;

    private Integer replyId;

    private Integer userId;

    private Integer videoId;

    private String detail;

    private Date commentDate;

    private Integer supportNum;

    private Integer opposeNum;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getSupportNum() {
        return supportNum;
    }

    public void setSupportNum(Integer supportNum) {
        this.supportNum = supportNum;
    }

    public Integer getOpposeNum() {
        return opposeNum;
    }

    public void setOpposeNum(Integer opposeNum) {
        this.opposeNum = opposeNum;
    }
}
