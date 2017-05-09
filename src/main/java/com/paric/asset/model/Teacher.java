package com.paric.asset.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher extends BaseCharacter implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7321616712237387305L;
	
	private String title; //职称
	
	//@ManyToOne
	private Institute institute; //学院
	
	//@ManyToMany
	private List<Course> courseList; //课程
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.LAZY, targetEntity=Institute.class)
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "teacher_course",
	joinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName ="id")})
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
}
