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
@Table(name="major")
public class Major extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2417998788709722808L;

	private String code; //代号
	
	//@ManyToOne
	private Institute institute; //学院entity
	
	//@OneToMany
	private List<Klass> klassList; //班级entity

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,targetEntity=Institute.class)
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="major",targetEntity=Klass.class)
	public List<Klass> getKlassList() {
		return klassList;
	}
	public void setKlassList(List<Klass> klassList) {
		this.klassList = klassList;
	}
	
}
