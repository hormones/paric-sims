package com.paric.asset.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1631538785869778173L;

	private int courseno;  //课程号  
	private int period;   //课时数  
	private String term;   //上课学期  
	private String category;   //课程类别 
	private String property;   //课程性质  
	
	//@ManyToMany
	private List<Teacher> teacherList; //教师entity
	
	//@ManyToMany
	private List<Student> studentList; //学生entity
	
	public int getCourseno() {
		return courseno;
	}
	public void setCourseno(int courseno) {
		this.courseno = courseno;
	}
	
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "teacher_course",
	joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName ="id")})
	public List<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "score",
	joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName ="id")})
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

}