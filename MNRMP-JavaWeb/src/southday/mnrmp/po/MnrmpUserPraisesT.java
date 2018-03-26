package southday.mnrmp.po;

import java.util.Date;

public class MnrmpUserPraisesT {
    private Integer praiseId;

    private Integer videoId;

    private Integer userId;

    private Date praiseDate;

    public Integer getPraiseId() {
        return praiseId;
    }

    public void setPraiseId(Integer praiseId) {
        this.praiseId = praiseId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPraiseDate() {
        return praiseDate;
    }

    public void setPraiseDate(Date praiseDate) {
        this.praiseDate = praiseDate;
    }
}
