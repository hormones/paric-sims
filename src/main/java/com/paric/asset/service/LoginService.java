package com.paric.asset.service;

import java.util.List;

import com.paric.asset.model.BaseModel;
import com.paric.asset.model.Student;

public interface LoginService extends BaseService<BaseModel> {
	public boolean pwdRevision(String userno, String newPassword, String identity);
	public List<Student> stuSearch(String userno);
	public <T> T login(String userno, String userpwd, Class<T> clazz);
}
