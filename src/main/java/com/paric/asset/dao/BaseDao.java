package com.paric.asset.dao;

import java.util.List;

public interface BaseDao<T> {
	public void save(T t); //保存对象
	public void update(T t); //更新对象
	public void delete(T t); //删除对象
	public T findById(Class<T> clazz, long id); //通过id查询对象
	public T findByName(Class<T> clazz, String name); //通过name查询对象
	public List<T> findByIds(Class<T> clazz, String ids); //通过id批量查询对象
	public int getAmount(Class<T> clazz); //查询某数据表总记录数
	public List<T> findAll(Class<T> clazz); //批量查询对象
	public List<T> findLikeName(Class<T> clazz, String name); //name模糊查询
	public void batchInsert(List<T> t,int size); //批量插入
	public void batchUpdate(List<T> t,int size); //批量更新
	public List<T> findAllByLimit(Class<T> clazz,int startRow, int rows); //通过限制条件批量查询对象
}