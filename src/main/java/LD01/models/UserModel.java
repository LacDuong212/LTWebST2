package LD01.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String passWord;
	private String avatar;
	private String fullName;
	private String email;
	private String phone;
	private int roleid;
	private Date createDate;

	public UserModel() {
		super();
	}

	public UserModel(int id, String userName, String passWord, String avatar, String fullName, String email,
			String phone, int roleid, Date createDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.avatar = avatar;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.roleid = roleid;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", avatar=" + avatar
				+ ", fullName=" + fullName + ", email=" + email + ", phone=" + phone + ", roleid=" + roleid
				+ ", createDate=" + createDate + "]";
	}

}
