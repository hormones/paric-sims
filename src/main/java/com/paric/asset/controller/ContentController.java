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
	public ModelAndView studentTablePage(@RequestParam String klass, String department, String college){
		ModelAndView mv = new ModelAndView("studentTablePage");
		mv.addObject("klass", klass);
		mv.addObject("department", department);
		mv.addObject("college", college);
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
}
