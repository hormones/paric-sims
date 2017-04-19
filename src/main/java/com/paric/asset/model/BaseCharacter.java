package com.paric.asset.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseCharacter extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3668117774482823571L;
	
	private String userno;
	
	private String userpwd;
	
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
