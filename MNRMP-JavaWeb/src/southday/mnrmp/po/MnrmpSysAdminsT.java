package southday.mnrmp.po;

import java.util.Date;

import southday.mnrmp.util.MnrmpUtil;

public class MnrmpSysAdminsT {
    private Integer adminId;

    private String adminName;

    private String account;

    private Date birthday;

    private Boolean sex;

    private String email;

    private String phone;

    private String password;

    private String headPortraitName;
    
    private String userTypeCode = MnrmpUtil.USER_TYPE_SYS_ADMIN; // 非数据库字段
    
    private Boolean hasLogined; // 非数据库字段
    
    public String getUserTypeCode() {
		return userTypeCode;
	}

	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode == null ? null : userTypeCode.trim();
	}

	public Boolean getHasLogined() {
		return hasLogined;
	}

	public void setHasLogined(Boolean hasLogined) {
		this.hasLogined = hasLogined;
	}

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHeadPortraitName() {
        return headPortraitName;
    }

    public void setHeadPortraitName(String headPortraitName) {
        this.headPortraitName = headPortraitName == null ? null : headPortraitName.trim();
    }
}