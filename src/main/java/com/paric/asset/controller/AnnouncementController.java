package com.paric.asset.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paric.asset.model.Administrator;
import com.paric.asset.model.Announcement;
import com.paric.asset.service.AnnouncementService;

@Controller
@RequestMapping("/announcement.do")
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService announcementService;
	
	//修改和新增公告
	@RequestMapping(params = "dispatch=modifyOrAddAnnouncement")
	public void modifyAnnouncement(HttpServletRequest request, String id,String name,String content){
		Announcement announcement = new Announcement();
		Administrator administrator = (Administrator) request.getSession().getAttribute("loginUser");
		if(null == id){
			//新增公告
			announcement.setName(name);
			announcement.setContent(content);
			announcement.setModifyTime(new Date(System.currentTimeMillis()));
			announcement.setAdministrator(administrator);
			announcementService.add(announcement);
		} else {
			//修改公告
			announcement = announcementService.findById(Announcement.class, Long.parseLong(id));
			announcement.setName(name);
			announcement.setContent(content);
			announcement.setModifyTime(new Date(System.currentTimeMillis()));
			announcement.setAdministrator(administrator);
			announcementService.update(announcement);
		}
	}
	
	//删除公告
	@RequestMapping(params = "dispatch=deleteAnnouncement")
	public void deleteAnnouncement(HttpServletRequest request, HttpServletResponse response, String id){
		Announcement announcement = announcementService.findById(Announcement.class, Long.parseLong(id));
		announcementService.delete(announcement);
	}

}