package com.paric.asset.service;

public interface BaseCharacterService<T> extends BaseService<T> {

	public T findByUserno(Class<T> clazz, String userno);
	
	public T login(Class<T> clazz, String userno, String userpwd);
	
	public boolean modifyPwd(Class<T> clazz, String newPwd);
	
}
