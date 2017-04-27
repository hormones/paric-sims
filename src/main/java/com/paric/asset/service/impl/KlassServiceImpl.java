package com.paric.asset.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paric.asset.dao.KlassDao;
import com.paric.asset.model.Klass;
import com.paric.asset.service.KlassService;

@Service("klassService")
@Transactional
public class KlassServiceImpl extends BaseServiceImpl<Klass> implements KlassService {
	
	@Autowired
	private KlassDao klassDao;

	@Override
	public Klass findKlassByName(String instituteName, String majorName, String klassName) {
		return klassDao.findKlassByName(instituteName, majorName, klassName);
	}

}
