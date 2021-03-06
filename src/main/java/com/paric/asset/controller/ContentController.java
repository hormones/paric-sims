package com.paric.asset.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.paric.asset.model.Announcement;
import com.paric.asset.model.Institute;
import com.paric.asset.model.Klass;
import com.paric.asset.model.Major;
import com.paric.asset.service.AnnouncementService;
import com.paric.asset.service.BaseService;

@Controller
@RequestMapping("/content.do")
public class ContentController<T> {
	
	@SuppressWarnings({ "rawtypes" })
	@Autowired
	private BaseService baseService;
	
	@Autowired
	private AnnouncementService announcementService;
	
	//跳转到公告页面
	@RequestMapping(params = "dispatch=toAnnouncement")
	public ModelAndView toAnnouncement(){
		ModelAndView mv = new ModelAndView("announcement/announcement");
		List<Announcement> announcementList = announcementService.findAll(Announcement.class);
		mv.addObject("announcementList", announcementList);
		return mv;
	}
	
	//跳转到修改密码页面
	@RequestMapping(params = "dispatch=toModifyPwd")
	public String toModifyPwd(){
		return "modifyPwd";
	}
	
	//跳转到学生表格页面
	@RequestMapping(params = "dispatch=toStudentTable")
	@ResponseBody
	public ModelAndView toStudentTable(@RequestParam String klassName, String majorName, String instituteName){
		ModelAndView mv = new ModelAndView("student/studentTable");
		mv.addObject("klassName", klassName);
		mv.addObject("majorName", majorName);
		mv.addObject("instituteName", instituteName);
		return mv;
	}
	
	@SuppressWarnings("unchecked")
	//跳转到查看某个学生信息页面
	@RequestMapping(params = "dispatch=toStudentInfo")
	public ModelAndView toStudentInfo(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("student/studentInfo");
		List<Institute> instituteList = baseService.findAll(Institute.class);
		List<Major> majorList = instituteList.get(0).getMajorList();
		List<Klass> klassList = majorList.get(0).getKlassList();
		mv.addObject("instituteList", instituteList);
		mv.addObject("majorList", majorList);
		mv.addObject("klassList", klassList);
		return mv;
	}
	
	//跳转到新增学生模态框
	@RequestMapping(params = "dispatch=toAddStudentModal")
	public String toAddStudentModal(){
		return "student/addStudentModal";
	}
	
	//跳转到查看公告页面
	@RequestMapping(params = "dispatch=toViewAnnouncement")
	public ModelAndView toViewAnnouncement(Long id){
		ModelAndView mv = new ModelAndView("announcement/viewAnnouncement");
		Announcement announcement = announcementService.findById(Announcement.class, id);
		mv.addObject("announcement", announcement);
		return mv;
	}
	
	//跳转到修改和新增公告页面
	@RequestMapping(params = "dispatch=toModifyOrAddAnnouncement")
	public ModelAndView toModifyOrAddAnnouncement(Long id){
		ModelAndView mv = new ModelAndView("announcement/modifyOrAddAnnouncement");
		if(null != id) {
			Announcement announcement = announcementService.findById(Announcement.class, id);
			mv.addObject("announcement", announcement);
		}
		return mv;
	}
	
	//跳转到全部公告页面
	@RequestMapping(params = "dispatch=toAnnouncementTable")
	public ModelAndView toAnnouncementTable(){
		ModelAndView mv = new ModelAndView("announcement/announcementTable");
		return mv;
	}
}