package southday.mnrmp.po;

public class MnrmpUserSessionT {
    private Integer alloctId;
    
    private String account;
    
    private String sessionId;
    
    private String userTypeCode;

    public Integer getAlloctId() {
        return alloctId;
    }

    public void setAlloctId(Integer alloctId) {
        this.alloctId = alloctId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public String getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(String userTypeCode) {
        this.userTypeCode = userTypeCode == null ? null : userTypeCode.trim();
    }
}
