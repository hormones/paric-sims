package com.paric.asset.dao;

import java.util.List;

import com.paric.asset.model.BaseCharacter;
import com.paric.asset.model.Student;

public interface LoginDao extends BaseDao<BaseCharacter> {
	public boolean pwdRevision(String userno, String newPassword, String identity);
	public List<Student> stuSearch(String userno);
	public <T extends BaseCharacter> T login(String userno, String userpwd, Class<T> clazz);
}