package com.paric.asset.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/announcement.do")
public class AnnouncementController {
	
	//修改和新增公告
	@RequestMapping(params = "dispatch=modifyOrAddAnnouncement")
	public String modifyAnnouncement(HttpServletRequest request, HttpServletResponse response){
		return null;
	}
	
	//删除公告
	@RequestMapping(params = "dispatch=deleteAnnouncement")
	public String deleteAnnouncement(HttpServletRequest request, HttpServletResponse response, String id){
		return null;
	}

}