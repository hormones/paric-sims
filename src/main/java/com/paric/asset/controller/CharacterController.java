package com.paric.asset.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paric.asset.model.BaseCharacter;
import com.paric.asset.service.BaseCharacterService;

@Controller
@RequestMapping("/character.do")
public class CharacterController {
	
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
			return "characterIndex";
		} else{
			System.out.println("登陆失败...");
		}
		return "redirect:login.jsp";
	}

	//验证旧密码
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(params = "dispatch=oldPwdBlur")
	@ResponseBody
	public Boolean oldPwdBlur(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		BaseCharacter loginUser = (BaseCharacter) request.getSession().getAttribute("loginUser");
		String identity = (String) request.getSession().getAttribute("identity");
		String oldPwd = request.getParameter("oldPwd");
		if(loginUser!=null && oldPwd!=""){
			Class clazz = Class.forName("com.paric.asset.model."+identity);
			BaseCharacter isLogin = (BaseCharacter) baseCharacterService.login(clazz, loginUser.getUserno(), oldPwd);
			if(isLogin!=null){
				System.out.println("旧密码输入正确...");
				return true;
			}
			System.out.println("旧密码输入错误...");
			return false;
		}
		System.out.println("操作异常，用户未登录...");
		return false;
	}
	
	//修改密码
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(params = "dispatch=modifyPwd")
	@ResponseBody
	public Map<String, Object> modifyPwd(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		BaseCharacter loginUser = (BaseCharacter) request.getSession().getAttribute("loginUser");
		String identity = (String) request.getSession().getAttribute("identity");
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		if(loginUser!=null && oldPwd!="" && newPwd!=""){
			Class clazz = Class.forName("com.paric.asset.model."+identity);
			BaseCharacter isLogin = (BaseCharacter) baseCharacterService.login(clazz, loginUser.getUserno(), oldPwd);
			if(isLogin!=null){
				boolean modifyPwdResult = baseCharacterService.modifyPwd(clazz, newPwd);
				if(modifyPwdResult){
					System.out.println("密码修改成功...");
					map.put("result", 1);
					return map;
				}
				System.out.println("密码修改失败...");
				map.put("result", 0);
				return map;
			}
			System.out.println("操作异常，用户未登录...");
		}
		map.put("result", 0);
		return map;
	}
	
	//用户注销
	@RequestMapping(params = "dispatch=loginOut")
	public String loginOut(HttpServletRequest request, HttpServletResponse response){
		request.getSession().invalidate();
		return "redirect:login.jsp";
	}
	
	//跳转到查看某个学生信息页面
	@RequestMapping(params = "dispatch=viewStudentInfo")
	public String studentInfo(HttpServletRequest request, HttpServletResponse response){
		return "studentInfoPage";
	}
}
