package com.paric.asset.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paric.asset.model.Student;
import com.paric.asset.service.LoginService;


@Controller
@RequestMapping("/login.do")
public class LoginController {
	
	@Resource
	private LoginService loginService;
	
	//登陆
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(params = "dispatch=login") 
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String userno = request.getParameter("userno");
		String userpwd = request.getParameter("userpwd");
		String identity = request.getParameter("identity");
		Class clazz = Class.forName("com.paric.asset.model."+identity);
		Object loginUser = loginService.login(userno, userpwd, clazz);
		if(loginUser!=null){
			HttpSession session = request.getSession(true);
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("identity", identity);
			System.out.println("登陆通过...");
			if(identity.equals("Student")){
				return "studentIndex";
			} else if(identity.equals("Teacher")){
				return "teacherIndex";
			} else if(identity.equals("Administrator")){
				return "administratorIndex";
			}
		} else{
			System.out.println("登陆失败...");
		}
		return "redirect:login.jsp";
		
	}
	
	//验证旧密码
//		@RequestMapping(params = "dispatch=oldPasswordBlur")
//		@ResponseBody
//		public Map<String, Object> oldPasswordBlur(HttpServletRequest request, HttpServletResponse response) throws Exception{
//			request.setCharacterEncoding("utf-8");
//			String user = (String) request.getSession().getAttribute("user");
//			String identity = (String) request.getSession().getAttribute("identity");
//			String oldPassword = request.getParameter("oldPassword");
//			Map<String, Object> map = new HashMap<String, Object>();
//			if(oldPassword!=""){
//				boolean isLogin = loginService.login(user, oldPassword, identity);
//				if(isLogin){
//					System.out.println("旧密码输入正确...");
//					map.put("success", true);
//					map.put("result", 1);
//					return map;
//				}
//				System.out.println("旧密码输入错误...");
//				map.put("success", true);
//				map.put("result", 0);
//				return map;
//			}
//			System.out.println("旧密码未输入...");
//			map.put("success", true);
//			map.put("result", 0);
//			return map;
//		}
	
	//修改密码
//	@RequestMapping(params = "dispatch=pwdRevision")
//	@ResponseBody
//	public Map<String, Object> pwdRevision(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		request.setCharacterEncoding("utf-8");
//		String user = (String) request.getSession().getAttribute("user");
//		String identity = (String) request.getSession().getAttribute("identity");
//		String oldPassword = request.getParameter("oldPassword");
//		String newPassword = request.getParameter("newPassword");
//		Map<String, Object> map = new HashMap<String, Object>();
//		if(oldPassword!=""&&newPassword!=""){
//			boolean isLogin = loginService.login(user, oldPassword, identity);
//			if(isLogin){
//				boolean isRevision = loginService.pwdRevision(user, newPassword, identity);
//				if(isRevision){
//					map.put("success", true);
//					map.put("result", 1);
//					return map;
//				} else {
//					System.out.println("密码修改失败...");
//					map.put("success", true);
//					map.put("result", 0);
//					return map;
//				}
//			}
//			System.out.println("旧密码输入错误...");
//			map.put("success", true);
//			map.put("result", 0);
//			return map;
//		}
//		map.put("success", true);
//		map.put("result", 0);
//		return map;
//	}
	
	//用户注销
	@RequestMapping(params = "dispatch=loginOut")
	public String loginOut(HttpServletRequest request, HttpServletResponse response){
		request.getSession().invalidate();
		return "redirect:login.jsp";
	}
	
	//跳转到修改密码页面
	@RequestMapping(params = "dispatch=revisePwdPage")
	public String showRevisePwdPage(HttpServletRequest request, HttpServletResponse response){
		return "revisePwd";
	}
	
	//查看某个学生信息页面
	@RequestMapping(params = "dispatch=stuSearch")
	@ResponseBody
	public Map<String, Object> stuSearch(HttpServletRequest request, HttpServletResponse response){
		String stuno = request.getParameter("stuno");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Student> list = loginService.stuSearch(stuno);
		map.put("success", true);
		map.put("result", list);
		return map;
	}
	
	//跳转到查看某个学生信息页面
	@RequestMapping(params = "dispatch=studentInfo")
	public String studentInfo(HttpServletRequest request, HttpServletResponse response){
		return "studentInfo";
	}
}
