package com.paric.asset.model;

import java.io.Serializable;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student extends BaseCharacter implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1981083654062194506L;
	
	private String stuemail;//邮箱
	private String stuIDnumber;//身份证号码
	private String stunationality;//民族
	private String stusex;//性别
	private Date stubirth;//出生日期
	private Date stuintime;//入学时间
	private String stupolitics;//政治面貌
	private String stucomefrom;//生源地
	private String stuhomeaddress;//家庭住址
	private String stunote;//备注
	
	//ManyToOne---Klass
	private Klass klass;
	
	//ManyToMany---Teacher
	private List<Teacher> teacherList;

	public String getStuemail() {
		return stuemail;
	}
	public void setStuemail(String stuemail) {
		this.stuemail = stuemail;
	}
	
	public String getStuIDnumber() {
		return stuIDnumber;
	}
	public void setStuIDnumber(String stuIDnumber) {
		this.stuIDnumber = stuIDnumber;
	}
	
	public String getStunationality() {
		return stunationality;
	}
	public void setStunationality(String stunationality) {
		this.stunationality = stunationality;
	}
	
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	
	public Date getStubirth() {
		return stubirth;
	}
	public void setStubirth(Date stubirth) {
		this.stubirth = stubirth;
	}
	
	public Date getStuintime() {
		return stuintime;
	}
	public void setStuintime(Date stuintime) {
		this.stuintime = stuintime;
	}
	
	public String getStupolitics() {
		return stupolitics;
	}
	public void setStupolitics(String stupolitics) {
		this.stupolitics = stupolitics;
	}
	
	public String getStucomefrom() {
		return stucomefrom;
	}
	public void setStucomefrom(String stucomefrom) {
		this.stucomefrom = stucomefrom;
	}
	
	public String getStuhomeaddress() {
		return stuhomeaddress;
	}
	public void setStuhomeaddress(String stuhomeaddress) {
		this.stuhomeaddress = stuhomeaddress;
	}
	
	public String getStunote() {
		return stunote;
	}
	public void setStunote(String stunote) {
		this.stunote = stunote;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "Teacher_Student",
	joinColumns = {@JoinColumn(name = "Student_ID", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "Teacher_ID", referencedColumnName ="id")})
	public List<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,targetEntity=Klass.class)
	public Klass getKlass() {
		return klass;
	}
	public void setKlass(Klass klass) {
		this.klass = klass;
	}
	
}
