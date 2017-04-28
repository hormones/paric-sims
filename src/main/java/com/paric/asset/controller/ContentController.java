package com.paric.asset.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	//跳转到学生表格页面
	@RequestMapping(params = "dispatch=studentTablePage")
	@ResponseBody
	public ModelAndView studentTablePage(@RequestParam String klassName, String majorName, String instituteName){
		ModelAndView mv = new ModelAndView("studentTablePage");
		mv.addObject("klassName", klassName);
		mv.addObject("majorName", majorName);
		mv.addObject("instituteName", instituteName);
		return mv;
	}
	
	//跳转到学生信息页面
	@RequestMapping(params = "dispatch=studentInfoPage")
	public String studentInfoPage(){
		return "studentInfoPage";
	}
	
	//跳转到新增学生模态框
	@RequestMapping(params = "dispatch=toAddStudentModal")
	public String toAddStudentModal(){
		return "addStudentModal";
	}
	
	//跳转到查看公告页面
	@RequestMapping(params = "dispatch=toViewAnnouncement")
	public String toViewAnnouncement(){
		return "viewAnnouncement";
	}
	
	//跳转到修改和新增公告页面
	@RequestMapping(params = "dispatch=toModifyOrAddAnnouncement")
	public String toModifyOrAddAnnouncement(){
		return "modifyOrAddAnnouncement";
	}
}
