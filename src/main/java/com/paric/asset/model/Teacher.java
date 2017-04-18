package com.paric.asset.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher extends BaseModel implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7321616712237387305L;
	
	private String teachergh;//工号
	private String teacherpwd;//密码
	
	//ManyToMany---Student
	private List<Student> studentList;
	
	public String getTeachergh() {
		return teachergh;
	}
	public void setTeachergh(String teachergh) {
		this.teachergh = teachergh;
	}
	
	public String getTeacherpwd() {
		return teacherpwd;
	}
	public void setTeacherpwd(String teacherpwd) {
		this.teacherpwd = teacherpwd;
	}
	
	@ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,targetEntity=Student.class)
	@JoinTable(name="teacher_student",joinColumns={@JoinColumn(name="s_id")},inverseJoinColumns={@JoinColumn(name="t_id")})
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
}
