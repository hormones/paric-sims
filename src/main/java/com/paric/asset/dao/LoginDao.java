package com.paric.asset.dao;

import java.util.List;

import com.paric.asset.model.BaseModel;
import com.paric.asset.model.Student;

public interface LoginDao extends BaseDao<BaseModel> {
	public boolean pwdRevision(String userno, String newPassword, String identity);
	public List<Student> stuSearch(String userno);
	public <T> T login(String userno, String userpwd, Class<T> clazz);
}