package com.paric.asset.service.impl;

import java.util.List;
import java.util.Map;

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
			jsonObject.put("gender", object[2]);
			jsonObject.put("instituteName", object[3]);
			jsonObject.put("majorName", object[4]);
			jsonObject.put("klassName", object[5]);
			jsonArray.add(jsonObject);
		}
		jsonObjects.put("rows", jsonArray);
		jsonObjects.put("total", total);
		return jsonObjects.toString();
	}

	@Override
	public JSONObject getStuInfoData(String keyword) {
		Student student = studentDao.getStuInfoData(keyword);
		JSONObject jsonObject = new JSONObject();
		if(null!=student){
			jsonObject.put("userno", student.getUserno());
			jsonObject.put("name", student.getName());
			jsonObject.put("nationality", student.getNationality());
			jsonObject.put("gender", student.getGender());
			jsonObject.put("instituteId", student.getKlass().getMajor().getInstitute().getId());
			jsonObject.put("majorId", student.getKlass().getMajor().getId());
			jsonObject.put("email", student.getEmail());
			jsonObject.put("klassId", student.getKlass().getId());
			jsonObject.put("birthday", String.valueOf(student.getBirthday()));
			jsonObject.put("stuintime", String.valueOf(student.getStuintime()));
			jsonObject.put("politics", student.getPolitics());
			jsonObject.put("idNumber", student.getIdNumber());
			jsonObject.put("stucomefrom", student.getStucomefrom());
			jsonObject.put("homeaddress", student.getHomeaddress());
			jsonObject.put("note", student.getNote());
		}
		return jsonObject;
	}

	@Override
	public void modifyStudent(Map<String, Object> stuMap, long id) {
		studentDao.modifyStudent(stuMap, id);
	}

}