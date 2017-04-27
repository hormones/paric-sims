package com.paric.asset.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseCharacter extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3668117774482823571L;
	
	private String userno; //账号(同时也是学生的学号、教师的工号)
	
	private String userpwd; //密码
	
	private String gender; //性别
	
	private String email; //邮箱
	
	private String phoneNumber; //手机号码
	
	private Date birthday; //出生日期
	
	private String idNumber; //身份证号码
	
	private String nationality; //民族
	
	private String politics; //政治面貌
	
	private String homeaddress; //家庭住址
	
	private String note;//备注

	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPolitics() {
		return politics;
	}
	public void setPolitics(String politics) {
		this.politics = politics;
	}

	public String getHomeaddress() {
		return homeaddress;
	}
	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
