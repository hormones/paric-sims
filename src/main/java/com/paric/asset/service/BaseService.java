package com.paric.asset.service;

import java.util.List;

public interface BaseService<T> {
	
	/**
	 * 持久化对象:新增
	 * @param t
	 */
	public void add(T t);
	
	/**
	 * 执行删除操作
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * 持久化对象:更新
	 * @param t
	 */
	public void update(T t);
	
	/**
	 * 通过id查询对象
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T findById(Class<T> clazz,long id);

	/**
	 * 通过name查询对象
	 * @param clazz
	 * @param name
	 * @return
	 */
	public T findByName(Class<T> clazz,String name);
	
	/**
	 * 通过id序列查询对象
	 * @param clazz
	 * @param ids 格式为eg:1,2,3
	 * @return
	 */
	public List<T> findByIds(Class<T> clazz, String ids);
	
	/**
	 * 获取该对象的数量
	 * @param clazz
	 * @return
	 */
	public int getAmount(Class<T> clazz);
	
	/**
	 * 查询所有对象
	 * @param clazz
	 * @return
	 */
	public List<T> findAll(Class<T> clazz);

	/**
	 * 通过Name模糊查询
	 * @param clazz
	 * @param name
	 * @return
	 */
	public List<T> findLikeName(Class<T> clazz,String name);
	
	/**
	 * 批量添加
	 * @param clazz
	 * @param size 批量添加的数量
	 */
	public void batchInsert(List<T> clazz,int size);
	
	/**
	 * 批量更新
	 * @param clazz
	 * @param size 批量更新的数量
	 */
	public void batchUpdate(List<T> clazz,int size);
	
	/**
	 * 查询所有对象(limit)
	 * @param clazz
	 * @param firstRow 起始页
	 * @param rows 每页显示的条数
	 */
	public List<T> findAllByLimit(Class<T> clazz,int startRow,int rows);
	
}
