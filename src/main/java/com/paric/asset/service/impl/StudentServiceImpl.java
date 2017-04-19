package com.paric.asset.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paric.asset.dao.StudentDao;
import com.paric.asset.model.Student;
import com.paric.asset.service.StudentService;

@Service("studentService")
@Transactional
public class StudentServiceImpl extends BaseCharacterServiceImpl<Student> implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
}
