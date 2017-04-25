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
public class Teacher extends BaseCharacter implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7321616712237387305L;
	
	//ManyToMany---Klass
	private List<Klass> klassList;
	
	//ManyToMany---Student
	private List<Student> studentList;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "Teacher_Student",
	joinColumns = {@JoinColumn(name = "Teacher_ID", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "Student_ID", referencedColumnName ="id")})
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "Teacher_Klass",
	joinColumns = {@JoinColumn(name = "Teacher_ID", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "Klass_ID", referencedColumnName ="id")})
	public List<Klass> getKlassList() {
		return klassList;
	}
	public void setKlassList(List<Klass> klassList) {
		this.klassList = klassList;
	}
	
}
