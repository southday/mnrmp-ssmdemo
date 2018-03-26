package southday.mnrmp.po;

import java.util.Date;

import southday.mnrmp.util.MnrmpUtil;

public class MnrmpUsersT {
    private Integer userId;

    private Integer roleId;

    private String account;

    private String userName;

    private Date birthday;

    private Boolean sex;

    private String email;

    private String phone;

    private String password;

    private Date registDate;

    private String headPortraitName;

    private Boolean isValid;
    
    private Boolean isActivated;
    
    private String activateCode;
    
    private String userTypeCode = MnrmpUtil.USER_TYPE_USER; // 非数据库字段
    
    private Boolean hasLogined; // 非数据库字段

    public String getActivateCode() {
		return activateCode;
	}

	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode == null ? null : activateCode.trim();
	}

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

	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
}