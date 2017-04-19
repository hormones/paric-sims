package com.paric.asset.dao.impl;

import org.springframework.stereotype.Repository;

import com.paric.asset.dao.StudentDao;
import com.paric.asset.model.Student;

@Repository("studentDao")
public class StudentDaoImpl extends BaseCharacterDaoImpl<Student> implements StudentDao {

}
