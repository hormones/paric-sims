package com.paric.asset.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="administrator")
public class Administrator extends BaseCharacter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3353682959733725603L;
	
	//@OneToMany
	private List<Announcement> announcementList; //公告entity
	
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="administrator",targetEntity=Announcement.class)
	public List<Announcement> getAnnouncementList() {
		return announcementList;
	}
	public void setAnnouncementList(List<Announcement> announcementList) {
		this.announcementList = announcementList;
	}
	
}
