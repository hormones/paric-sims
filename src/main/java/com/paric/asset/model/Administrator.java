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
	
	private String userno;//管理员Id
	
	private String userpwd;//密码
	
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	
}
