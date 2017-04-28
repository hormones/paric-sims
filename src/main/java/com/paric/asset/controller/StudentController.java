package com.paric.asset.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paric.asset.model.BaseCharacter;
import com.paric.asset.service.StudentService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/student.do")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(params = "dispatch=viewStudentTable")
	@ResponseBody
	public String viewStudentTable(HttpServletRequest request, @RequestParam String instituteName,String majorName,String klassName, Integer pageNumber, Integer pageSize){
		String identity = (String) request.getSession().getAttribute("identity");
		String teacherName = null;
		if (identity.equals("Teacher")){
			teacherName = ((BaseCharacter)request.getSession().getAttribute("loginUser")).getName();
		}
		return studentService.loadStudentTable(teacherName, instituteName, majorName, klassName, pageNumber, pageSize);
	}
	
	@RequestMapping(params = "dispatch=stuInfoData")
	@ResponseBody
	public String stuInfoData(HttpServletRequest request, @RequestParam String keyword){
		JSONObject jsonObject = new JSONObject();
		if(StringUtils.isNotBlank(keyword)){
			jsonObject =  studentService.getStuInfoData(keyword);
		}
		return jsonObject.toString();
	}

}