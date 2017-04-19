package com.paric.asset.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.paric.asset.dao.LoginDao;
import com.paric.asset.model.BaseCharacter;
import com.paric.asset.model.Student;
import com.paric.asset.service.LoginService;

@Service("loginService")
@Transactional
public class LoginServiceImpl extends BaseServiceImpl<BaseCharacter> implements LoginService{
	
	@Resource
	private LoginDao loginDao;
	
	@Override
	public <T extends BaseCharacter> T login(String userno, String userpwd, Class<T> clazz) {
		return loginDao.login(userno, userpwd, clazz);
	}

	@Override
	public boolean pwdRevision(String userno, String newPassword, String identity) {
		return loginDao.pwdRevision(userno, newPassword, identity);
	}

	@Override
	public List<Student> stuSearch(String userno) {
		return loginDao.stuSearch(userno);
	}

}
