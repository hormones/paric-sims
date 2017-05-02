package com.paric.asset.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.paric.asset.model.Teacher;
import com.paric.asset.service.TeacherService;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements TeacherService {

}
