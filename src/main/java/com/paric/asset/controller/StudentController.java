package com.paric.asset.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paric.asset.model.BaseCharacter;
import com.paric.asset.service.StudentService;

@Controller
@RequestMapping("/student.do")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(params = "dispatch=viewStudentTable")
	@ResponseBody
	public String viewStudentTable(HttpServletRequest request, @RequestParam String college,String department,String klassName, Integer pageNumber, Integer pageSize){
		String identity = (String) request.getSession().getAttribute("identity");
		String teacherName = null;
		if (identity.equals("Teacher")){
			teacherName = ((BaseCharacter)request.getSession().getAttribute("loginUser")).getName();
		}
		return studentService.loadStudentTable(teacherName, college, department, klassName, pageNumber, pageSize);
	}
	
	@RequestMapping(params = "dispatch=stuInfoData")
	@ResponseBody
	public String stuInfoData(HttpServletRequest request, @RequestParam String userno){
		return studentService.getStuInfoData(userno);
	}

}
