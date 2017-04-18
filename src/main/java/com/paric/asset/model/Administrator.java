package com.paric.asset.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="administrator")
public class Administrator extends BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3353682959733725603L;
	
	private String userid;//管理员Id
	private String userpwd;//密码
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	
}
