package com.paric.asset.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paric.asset.model.Administrator;
import com.paric.asset.model.Announcement;
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
	@RequestMapping(params = "dispatch=deleteAnnouncement")
	public void deleteAnnouncement(HttpServletRequest request, HttpServletResponse response, String id){
		Announcement announcement = announcementService.findById(Announcement.class, Long.parseLong(id));
		announcementService.delete(announcement);
	}

}