package com.paric.asset.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="institute")
public class Institute extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -496833484007261203L;
	
	private String code; //代号
	
	//@OneToMany
	private List<Major> majorList; //专业entity

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="institute",targetEntity=Major.class)
	public List<Major> getMajorList() {
		return majorList;
	}
	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}
	
}
