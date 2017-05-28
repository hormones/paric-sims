package com.paric.asset.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paric.asset.model.Administrator;
import com.paric.asset.model.Announcement;
import com.paric.asset.model.BaseCharacter;
import com.paric.asset.model.Student;
import com.paric.asset.service.AnnouncementService;
import com.paric.asset.service.BaseCharacterService;

@Controller
@RequestMapping("/announcement.do")
public class AnnouncementController {
	
	protected static final Logger logger = Logger.getLogger(AnnouncementController.class);
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseCharacterService baseCharacterService;
	
	@Autowired
	private AnnouncementService announcementService;
	
	@SuppressWarnings("unchecked")
	//修改和新增公告
	@RequestMapping(params = "dispatch=modifyOrAddAnnouncement")
	@ResponseBody
	public Map<String, Object> modifyAnnouncement(HttpServletRequest request, String id,String name,String content){
		Map<String, Object> map = new HashMap<String, Object>();
		Administrator administrator = (Administrator) request.getSession().getAttribute("loginUser");
		Administrator currentAdministrator = (Administrator) baseCharacterService.findById(Administrator.class, administrator.getId());
		map.put("success", false);
		if(null == id){
			//新增公告
			Announcement announcement = new Announcement();
			announcement.setName(name);
			announcement.setContent(content);
			announcement.setModifyTime(new Date(System.currentTimeMillis()));
			announcement.setAdministrator(currentAdministrator);
			announcementService.add(announcement);
			logger.debug("新增了公告: " + announcement.getName());
			map.put("success", true);
		} else {
			//修改公告
			Announcement announcement = announcementService.findById(Announcement.class, Long.parseLong(id));
			announcement.setName(name);
			announcement.setContent(content);
			announcement.setModifyTime(new Date(System.currentTimeMillis()));
			announcement.setAdministrator(currentAdministrator);
			announcementService.update(announcement);
			logger.debug("修改了公告: " + announcement.getName());
			map.put("success", true);
		}
		return map;
	}
	
	//删除公告
	@RequestMapping(params = "dispatch=deleteOneAnnouncement")
	@ResponseBody
	public Map<String, Object> deleteAnnouncement(HttpServletRequest request, HttpServletResponse response, String id){
		Map<String, Object> map = new HashMap<String, Object>();
		Announcement announcement = announcementService.findById(Announcement.class, Long.parseLong(id));
		map.put("success", false);
		if(null != announcement){
			announcementService.delete(announcement);
			map.put("success", true);
			System.out.println("删除了公告: " + announcement.getName());
		}
		return map;
	}
	
	//查看所有公告
	@RequestMapping(params = "dispatch=viewAnnouncementTable")
	@ResponseBody
	public String viewAnnouncementTable(HttpServletRequest request, @RequestParam Integer pageNumber, Integer pageSize){
		return announcementService.loadAnnouncementTable(pageNumber, pageSize);
	}

}