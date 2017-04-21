package com.paric.asset.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.paric.asset.model.Klass;

@Controller
@RequestMapping("/content.do")
public class ContentController {
	
	//跳转到公告页面
	@RequestMapping(params = "dispatch=announcementPage")
	public String announcementPage(){
		return "announcementPage";
	}
	
	//跳转到修改密码页面
	@RequestMapping(params = "dispatch=revisePwdPage")
	public String revisePwdPage(){
		return "revisePwdPage";
	}
	
	@RequestMapping(params = "dispatch=studentTablePage")
	@ResponseBody
	public ModelAndView studentTablePage(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("studentTablePage");
		Klass klass = new Klass();
		mv.addObject("klass", klass);
		return mv;
	}
}
