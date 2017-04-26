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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="klass")
public class Klass extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4665153658988311374L;
	
	private String grade; //年级
	
	//@ManyToOne
	private Major major; //专业entity
	
	//@OneToMany
	private List<Student> studentList; //学生entity
	
	/*//@ManyToMany
	private List<Teacher> teacherList; //教师entity
*/	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,targetEntity=Major.class)
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}

	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="klass",targetEntity=Student.class)
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	/*@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "Teacher_Klass",
	joinColumns = {@JoinColumn(name = "Klass_ID", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "Teacher_ID", referencedColumnName ="id")})
	public List<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}*/
	
}