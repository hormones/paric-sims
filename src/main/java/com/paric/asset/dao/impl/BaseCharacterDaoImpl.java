package com.paric.asset.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.paric.asset.dao.BaseCharacterDao;

@Repository("baseCharacterDao")
public class BaseCharacterDaoImpl<T> extends BaseDaoImpl<T> implements BaseCharacterDao<T>{

	@SuppressWarnings("unchecked")
	@Override
	public T findByUserno(Class<T> clazz, String userno){
		String hql = "FROM "+clazz.getSimpleName()+" WHERE userno='"+userno+"'";
		logger.debug(hql);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list().size()>0){
			return (T) query.list().get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T login(Class<T> clazz, String userno, String userpwd) {
		String hql = "FROM "+clazz.getSimpleName()+" WHERE userno='"+userno+"' AND userpwd='"+userpwd+"'";
		logger.debug(hql);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list().size()>0){
			return (T) query.list().get(0);
		}
		return null;
	};
	
}
