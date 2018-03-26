package southday.mnrmp.po;

import java.util.Date;

import southday.mnrmp.util.MnrmpUtil;

public class MnrmpResManagersT {
    private Integer managerId;

    private String managerName;

    private String account;

    private Date birthday;

    private Boolean sex;

    private String email;

    private String phone;

    private String password;

    private Date registDate;

    private String headPortraitName;
    
    private String userTypeCode = MnrmpUtil.USER_TYPE_RES_MANAGER; // 非数据库字段
    
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

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
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

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public String getHeadPortraitName() {
        return headPortraitName;
    }

    public void setHeadPortraitName(String headPortraitName) {
        this.headPortraitName = headPortraitName == null ? null : headPortraitName.trim();
    }
}