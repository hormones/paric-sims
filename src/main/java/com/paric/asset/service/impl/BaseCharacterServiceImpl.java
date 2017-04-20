package com.paric.asset.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paric.asset.dao.BaseCharacterDao;
import com.paric.asset.model.BaseCharacter;
import com.paric.asset.service.BaseCharacterService;

@Service("baseCharacterService")
@Transactional
public class BaseCharacterServiceImpl<T> extends BaseServiceImpl<T> implements BaseCharacterService<T> {

	@Autowired
	private BaseCharacterDao<T> baseCharacterDao;
	
	@Override
	public T findByUserno(Class<T> clazz, String userno) {
		return baseCharacterDao.findByUserno(clazz, userno);
	}

	@Override
	public T login(Class<T> clazz, String userno, String userpwd) {
		return baseCharacterDao.login(clazz, userno, userpwd);
	}

	@Override
	public boolean modifyPwd(Class<T> clazz, String newPwd) {
		return baseCharacterDao.modifyPwd(clazz, newPwd);
	}

}
