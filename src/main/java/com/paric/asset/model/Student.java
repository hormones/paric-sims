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
	
	private Date stuintime; //入学时间
	
	private String stucomefrom; //生源地
	
	//@ManyToOne
	private Klass klass; //班级entity
	
	//@ManyToMany
	private List<Course> courseList; //课程entity
	
	public Date getStuintime() {
		return stuintime;
	}
	public void setStuintime(Date stuintime) {
		this.stuintime = stuintime;
	}
	
	public String getStucomefrom() {
		return stucomefrom;
	}
	public void setStucomefrom(String stucomefrom) {
		this.stucomefrom = stucomefrom;
	}
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,targetEntity=Klass.class)
	public Klass getKlass() {
		return klass;
	}
	public void setKlass(Klass klass) {
		this.klass = klass;
	}

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "score",
	joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName ="id")})
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
}