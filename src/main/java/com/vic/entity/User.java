package com.vic.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author vic
 * @desc entity for table(user)
 * 
 */

public class User implements Serializable {

	//DefaultSerializer requires a Serializable payload but received an object of type [com.vic.entity.User]
	private static final long serialVersionUID = 8096359915405791915L;

	private int userId;

	private String userName;

	private String password;

	private String name;

	private int sex;

	private String tel;

	private int status;

	private boolean enable;

	private Date createdTime;

	private String desc;
	
	
	

	public User(String userName, String password, String name) {
		this.userName = userName;
		this.password = password;
		this.name = name;
	}

	public User(int userId, String userName, String password, String name, int sex, String tel, int status,
			boolean enable, Date createdTime, String desc) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.status = status;
		this.enable = enable;
		this.createdTime = createdTime;
		this.desc = desc;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", sex=" + sex + ", tel=" + tel + ", status=" + status + ", enable=" + enable + ", createdTime="
				+ createdTime + ", desc=" + desc + "]";
	}

}
