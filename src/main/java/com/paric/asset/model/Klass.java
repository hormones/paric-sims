package com.paric.asset.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="klass")
public class Klass extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4665153658988311374L;

	private String klassDepartment; 
	
	private String klassCollege;
	
	private String klassGrade;

	//OneToMany---Student
	private List<Student> studentList;
	
	//ManyToMany---Teacher
	private List<Teacher> teacherList;
	
	public String getKlassDepartment() {
		return klassDepartment;
	}
	public void setKlassDepartment(String klassDepartment) {
		this.klassDepartment = klassDepartment;
	}

	public String getKlassCollege() {
		return klassCollege;
	}
	public void setKlassCollege(String klassCollege) {
		this.klassCollege = klassCollege;
	}

	public String getKlassGrade() {
		return klassGrade;
	}
	public void setKlassGrade(String klassGrade) {
		this.klassGrade = klassGrade;
	}
	
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="klass",targetEntity=Student.class)
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	@ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,targetEntity=Teacher.class)
	@JoinTable(name="teacher_klass",joinColumns={@JoinColumn(name="k_id")},inverseJoinColumns={@JoinColumn(name="t_id")})
	public List<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
}
