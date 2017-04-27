package com.paric.asset.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="announcement")
public class Announcement extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6741262294181143926L;
	
	private String content; //内容
	
	private Date createTime; //建立时间
	
	//@ManyToOne
	private Administrator administrator; //管理员entity

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,targetEntity=Administrator.class)
	public Administrator getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

}
