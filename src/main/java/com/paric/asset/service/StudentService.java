package com.paric.asset.service;

import com.paric.asset.model.Student;

public interface StudentService extends BaseCharacterService<Student> {
	
	public String loadStudentTable(String teacherName, String college,String department,String klassName, int pageNumber, int pageSize);

	public String getStuInfoData(String userno);

}
