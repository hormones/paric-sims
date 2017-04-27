package com.paric.asset.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	private String code; //代号
	
	private String grade; //年级
	
	//@ManyToOne
	private Major major; //专业entity
	
	//@OneToMany
	private List<Student> studentList; //学生entity
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
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
	
}