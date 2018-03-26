package southday.mnrmp.po;

public class MnrmpCommentEx extends MnrmpUserCommentsT {
    
    private String userName;
    
    private Boolean hasReply = false;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getHasReply() {
        return hasReply;
    }

    public void setHasReply(Boolean hasReply) {
        this.hasReply = hasReply;
    }

}
