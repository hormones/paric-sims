package com.paric.asset.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.paric.asset.model.Teacher;
import com.paric.asset.service.TeacherService;

@Controller
@RequestMapping("/teacher.do")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	@RequestMapping(params = "dispatch=toTeacherTable")
	@ResponseBody
	public void stuInfoData(HttpServletRequest request, @RequestParam String keyword){
		ModelAndView mv = new ModelAndView("");
		List<Teacher> teacherList =  teacherService.findAll(Teacher.class);
		mv.addObject("teacherList", teacherList);
	}
	
}