package com.paric.asset.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu.do")
public class MenuController {
	
	//跳转到公告页面
	@RequestMapping(params = "dispatch=announcementPage")
	public String announcementPage(HttpServletRequest request, HttpServletResponse response){
		return "announcementPage";
	}
	
	//跳转到修改密码页面
	@RequestMapping(params = "dispatch=revisePwdPage")
	public String revisePwdPage(HttpServletRequest request, HttpServletResponse response){
		return "revisePwdPage";
	}
}
