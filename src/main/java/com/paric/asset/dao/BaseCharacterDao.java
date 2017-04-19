package com.paric.asset.dao;

public interface BaseCharacterDao<T> extends BaseDao<T> {
	
	public T findByUserno(Class<T> clazz, String userno);
	
	public T login(Class<T> clazz, String userno, String userpwd);
	
}
