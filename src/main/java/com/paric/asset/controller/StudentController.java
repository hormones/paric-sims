package com.paric.asset.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paric.asset.model.BaseCharacter;
import com.paric.asset.model.Klass;
import com.paric.asset.model.Student;
import com.paric.asset.service.KlassService;
import com.paric.asset.service.StudentService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/student.do")
public class StudentController {
	
	protected static final Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private KlassService klassService;
	
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));  
	}
	
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
	
	@RequestMapping(params = "dispatch=deleteOneStudent")
	@ResponseBody
	public Map<String, Object> deleteOneStudent(HttpServletRequest request, @RequestParam String userno){
		Map<String, Object> map = new HashMap<String, Object>();
		Student student = studentService.findByUserno(Student.class, userno);
		map.put("success", false);
		if(null != student){
			studentService.delete(student);
			map.put("success", true);
			System.out.println("删除了学生: " + student.getName());
		}
		return map;
	}
	
	@RequestMapping(params = "dispatch=modifyOrAddStudent")
	@ResponseBody
	public Map<String, Object> modifyOrAddStudent(HttpServletRequest request, @RequestParam Date stubirth, Date stuintime){
		String userno = request.getParameter("userno");
		String name = request.getParameter("name");
		String stusex = request.getParameter("stusex");
		String stunationality = request.getParameter("stunationality");
		
		//获得班级
		String klassId = request.getParameter("klassId");
		Klass klass = klassService.findById(Klass.class, Long.parseLong(klassId));
		
		String stuemail = request.getParameter("stuemail");
		String stupolitics = request.getParameter("stupolitics");
		String stuIDnumber = request.getParameter("stuIDnumber");
		String stucomefrom = request.getParameter("stucomefrom");
		String stuhomeaddress = request.getParameter("stuhomeaddress");
		String stunote = request.getParameter("stunote");

		Map<String,Object> stuMap = new HashMap<String,Object>();
		stuMap.put("userno", userno);
		stuMap.put("name", name);
		stuMap.put("klass", Long.parseLong(klassId));
		stuMap.put("gender", stusex);
		stuMap.put("nationality", stunationality);
		stuMap.put("email", stuemail);
		stuMap.put("birthday", stubirth);
		stuMap.put("stuintime", stuintime);
		stuMap.put("politics", stupolitics);
		stuMap.put("idNumber", stuIDnumber);
		stuMap.put("stucomefrom", stucomefrom);
		stuMap.put("homeaddress", stuhomeaddress);
		stuMap.put("note", stunote);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		Student studentInBase = studentService.findByUserno(Student.class, userno);
		map.put("success", false);
		if(null == studentInBase){ 
			//新增学生
			Student student = new Student();
			student.setName(name);
			student.setUserno(userno);
			student.setKlass(klass);
			student.setGender(stusex);
			student.setNationality(stunationality);
			student.setEmail(stuemail);
			student.setBirthday(stubirth);
			student.setStuintime(stuintime);
			student.setPolitics(stupolitics);
			student.setIdNumber(stuIDnumber);
			student.setStucomefrom(stucomefrom);
			student.setHomeaddress(stuhomeaddress);
			student.setNote(stunote);
			
			studentService.add(student);
			logger.debug("新增了学生: " + student.getName());
			map.put("success", true);
		} else {
			//修改学生
			studentService.modifyStudent(stuMap, studentInBase.getId());
			logger.debug("修改了学生: " + name);
			map.put("success", true);
		}
		return map;
	}

}