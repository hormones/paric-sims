package com.paric.asset.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paric.asset.model.BaseCharacter;
import com.paric.asset.model.Student;
import com.paric.asset.service.BaseCharacterService;
import com.paric.asset.service.LoginService;


@Controller
@RequestMapping("/login.do")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseCharacterService baseCharacterService;
	
	//登陆
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(params = "dispatch=login") 
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String userno = request.getParameter("userno");
		String userpwd = request.getParameter("userpwd");
		String identity = request.getParameter("identity");
		Class clazz = Class.forName("com.paric.asset.model."+identity);
		BaseCharacter loginUser = (BaseCharacter) baseCharacterService.login(clazz, userno, userpwd);
		if(loginUser!=null){
			HttpSession session = request.getSession(true);
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("identity", identity);
			System.out.println("登陆通过...");
			//将identity首字母小写并拼接成页面的名字
			char[] cs=identity.toCharArray();
	        cs[0] += 32;
	        String Character = String.valueOf(cs)+"Index";
			return Character;
		} else{
			System.out.println("登陆失败...");
		}
		return "redirect:login.jsp";
	}

	//跳转到修改密码页面
	@RequestMapping(params = "dispatch=revisePwdPage")
	public String showRevisePwdPage(HttpServletRequest request, HttpServletResponse response){
		return "revisePwdPage";
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
	
	//查看某个学生信息页面
	@RequestMapping(params = "dispatch=stuSearch")
	@ResponseBody
	public Map<String, Object> stuSearch(HttpServletRequest request, HttpServletResponse response){
		String userno = request.getParameter("userno");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Student> list = loginService.stuSearch(userno);
		map.put("success", true);
		map.put("result", list);
		return map;
	}
	
	//跳转到查看某个学生信息页面
	@RequestMapping(params = "dispatch=viewStudentInfo")
	public String studentInfo(HttpServletRequest request, HttpServletResponse response){
		return "studentInfoPage";
	}
}
