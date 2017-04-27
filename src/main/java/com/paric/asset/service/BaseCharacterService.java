package com.paric.asset.service;

public interface BaseCharacterService<T> extends BaseService<T> {

	/***
	 * 通过userno寻找角色
	 * @param clazz
	 * @param userno
	 * @return
	 */
	public T findByUserno(Class<T> clazz, String userno);
	
	/***
	 * 角色登录
	 * @param clazz
	 * @param userno
	 * @param userpwd
	 * @return
	 */
	public T login(Class<T> clazz, String userno, String userpwd);
	
	/***
	 * 修改密码
	 * @param clazz
	 * @param newPwd
	 * @return
	 */
	public boolean modifyPwd(Class<T> clazz, String newPwd);
	
}
