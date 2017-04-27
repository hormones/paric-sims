package com.paric.asset.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher extends BaseCharacter implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7321616712237387305L;
	
	private String title; //职称
	
	//@OneToMany
	private List<Course> courseList;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="teacher",targetEntity=Course.class)
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
}
