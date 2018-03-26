package southday.mnrmp.po;

import java.util.Date;

public class MnrmpUserSeesT {
    private Long seeId;

    private Integer userId;

    private Integer videoId;

    private Date seeDate;

    public Long getSeeId() {
        return seeId;
    }

    public void setSeeId(Long seeId) {
        this.seeId = seeId;
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

    public Date getSeeDate() {
        return seeDate;
    }

    public void setSeeDate(Date seeDate) {
        this.seeDate = seeDate;
    }
}
