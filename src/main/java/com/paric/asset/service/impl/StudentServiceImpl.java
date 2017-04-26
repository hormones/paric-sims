package com.paric.asset.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paric.asset.dao.StudentDao;
import com.paric.asset.model.Student;
import com.paric.asset.service.StudentService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("studentService")
@Transactional
public class StudentServiceImpl extends BaseCharacterServiceImpl<Student> implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public String loadStudentTable(String teacherName, String college,String department,String klassName, int pageNumber, int pageSize) {
		List<Object[]> list = studentDao.loadStudentTable(teacherName,  college, department, klassName, pageNumber, pageSize);
		int total = studentDao.getStudentTableRows(teacherName, college, department, klassName);
		JSONObject jsonObjects = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (Object[] object : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("userno", object[0]);
			jsonObject.put("name", object[1]);
			jsonObject.put("stusex", object[2]);
			jsonObject.put("klassName", object[3]);
			jsonArray.add(jsonObject);
		}
		jsonObjects.put("rows", jsonArray);
		jsonObjects.put("total", total);
		return jsonObjects.toString();
	}

	@Override
	public String getStuInfoData(String userno) {
		Student student = studentDao.getStuInfoData(userno);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userno", student.getUserno());
		jsonObject.put("name", student.getName());
		jsonObject.put("stunationality", student.getStunationality());
		jsonObject.put("stusex", student.getStusex());
		//jsonObject.put("college", student.getKlass().getKlassCollege());
		//jsonObject.put("department", student.getKlass().getKlassDepartment());
		jsonObject.put("stuemail", student.getStuemail());
		jsonObject.put("klassName", student.getKlass().getName());
		jsonObject.put("stubirth", String.valueOf(student.getStubirth()));
		jsonObject.put("stuintime", String.valueOf(student.getStuintime()));
		jsonObject.put("stupolitics", student.getStupolitics());
		jsonObject.put("stuIDnumber", student.getStuIDnumber());
		jsonObject.put("stucomefrom", student.getStucomefrom());
		jsonObject.put("stuhomeaddress", student.getStuhomeaddress());
		jsonObject.put("stunote", student.getStunote());
		return jsonObject.toString();
	}
	
}
