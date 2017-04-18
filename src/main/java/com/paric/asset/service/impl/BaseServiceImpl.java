package com.paric.asset.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paric.asset.dao.BaseDao;
import com.paric.asset.service.BaseService;

@Service("baseService")
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {

	protected static final Logger logger = Logger.getLogger(BaseService.class);
	
	@Autowired
	protected BaseDao<T> baseDao; 

	@Override
	public void add(T t) {
		baseDao.save(t);
	}

	@Override
	public void delete(T t) {
		baseDao.delete(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public T findById(Class<T> clazz, long id) {
		return baseDao.findById(clazz, id);
	}

	@Override
	public T findByName(Class<T> clazz, String name) {
		return baseDao.findByName(clazz, name);
	}

	@Override
	public List<T> findByIds(Class<T> clazz, String ids) {
		return baseDao.findByIds(clazz, ids);
	}

	@Override
	public int getAmount(Class<T> clazz) {
		return baseDao.getAmount(clazz);
	}

	@Override
	public List<T> findAll(Class<T> clazz) {
		logger.debug("BaseServiceImpl.findAll");
		return this.baseDao.findAll(clazz);
	}
	

	@Override
	public List<T> findLikeName(Class<T> clazz, String name) {
		logger.debug("BaseServiceImpl.findLikeName");
		return this.baseDao.findLikeName(clazz,name);
	}

	@Override
	public void batchInsert(List<T> clazz, int size){
		baseDao.batchInsert(clazz, size);
	}

	@Override
	public void batchUpdate(List<T> clazz,int size){
		baseDao.batchUpdate(clazz, size);
	}

	@Override
	public List<T> findAllByLimit(Class<T> clazz, int startRow, int rows) {
		logger.debug("BaseServiceImpl.findAllByLimit");
		return this.baseDao.findAllByLimit(clazz, startRow, rows);
	}

}
