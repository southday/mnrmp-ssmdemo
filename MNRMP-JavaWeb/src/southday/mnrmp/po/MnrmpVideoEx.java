package southday.mnrmp.po;

/**
 * 视频扩展类，目前只增加了managerId字段
 * @author southday
 * @date Sep 21, 2016
 */
public class MnrmpVideoEx extends MnrmpVideosT {
    private Integer managerId;
    
    private String userName;
    
    private String description;
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
    
}
