package com.paric.asset.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student.do")
public class StudentController {
	
	@RequestMapping(params = "dispatch=initStudentTable")
	@ResponseBody
	public Map<String,Boolean> initStudentTable(HttpServletRequest request, HttpServletResponse response){
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		map.put("success", true);
		return map;
	}
}
