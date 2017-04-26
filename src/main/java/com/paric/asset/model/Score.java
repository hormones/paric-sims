package com.paric.asset.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score extends BaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -455319715810262946L;
	
	/*private int id;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/

	private double scores; //分数

	//@OneToMany
	private Student student; //学生entity
	
	//@OneToMany
	private Course course; //课程entity
	
	public double getScores() {
		return scores;
	}
	public void setScores(double scores) {
		this.scores = scores;
	}

	@JoinColumn(name="student_id")
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,targetEntity=Student.class)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	@JoinColumn(name="course_id")
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,targetEntity=Course.class)
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}