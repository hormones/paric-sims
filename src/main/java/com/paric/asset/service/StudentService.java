package com.paric.asset.service;

import java.util.Map;

import com.paric.asset.model.Student;

import net.sf.json.JSONObject;

public interface StudentService extends BaseCharacterService<Student> {
	
	/***
	 * 以班级为单位通过表格展示学生信息
	 * @param teacherName
	 * @param college
	 * @param department
	 * @param klassName
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public String loadStudentTable(String teacherName, String college,String department,String klassName, int pageNumber, int pageSize);

	/***
	 * 通过关键字获得某个学生的信息
	 * @param keyword
	 * @return
	 */
	public JSONObject getStuInfoData(String keyword);
	
	/***
	 * 修改学生信息
	 * @param stuMap
	 * @param id
	 */
	public void modifyStudent(Map<String, Object> stuMap, long id);

}