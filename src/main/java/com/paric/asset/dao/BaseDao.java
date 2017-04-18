package com.paric.asset.dao;

import java.util.List;

public interface BaseDao<T> {
	
	public void save(T t);
	public void update(T t);
	public void delete(T t);
	public T findById(Class<T> clazz, long id);
	public T findByName(Class<T> clazz, String name);
	public List<T> findByIds(Class<T> clazz, String ids);
	public int getAmount(Class<T> clazz);
	public List<T> findAll(Class<T> clazz);
	public List<T> findLikeName(Class<T> clazz, String name);
	public void batchInsert(List<T> t,int size);
	public void batchUpdate(List<T> t,int size);
	public List<T> findAllByLimit(Class<T> clazz,int startRow, int rows);

}
