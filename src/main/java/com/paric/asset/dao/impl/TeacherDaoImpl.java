package com.paric.asset.dao.impl;

import org.springframework.stereotype.Repository;

import com.paric.asset.dao.TeacherDao;
import com.paric.asset.model.Teacher;

@Repository("teacherDao")
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao{

}
