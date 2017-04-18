package com.paric.asset.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paric.asset.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	protected static final Logger logger = Logger.getLogger(BaseDaoImpl.class);
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	@Override
	public void save(T t) {
		this.sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void update(T t) {
		this.sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void delete(T t) {
		this.sessionFactory.getCurrentSession().delete(t);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Class<T> clazz, long id) {
		return (T)this.sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByName(Class<T> clazz, String name) {
		String hql = "FROM "+clazz.getSimpleName()+" WHERE name = '"+name+"'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql); 
		if(query.list().size() > 0) {
			return (T) query.list().get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByIds(Class<T> clazz, String ids) {
		String hql = "FROM "+clazz.getSimpleName()+" WHERE id IN ("+ ids +")";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql); 
		return query.list();
	}

	@Override
	public int getAmount(Class<T> clazz) {
		String hql = "SELECT COUNT(*) FROM "+clazz.getSimpleName();
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql); 
		int amount = ((Number)query.uniqueResult()).intValue();
		return amount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> clazz) {
		String hql = "FROM "+clazz.getSimpleName();
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql); 
		return (List<T>)query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findLikeName(Class<T> clazz, String name) {
		String hql = "FROM "+clazz.getSimpleName()+" WHERE name like '%"+name+"%'";
		logger.debug(hql);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql); 
		return (List<T>)query.list();
	}

	@Override
	public void batchInsert(List<T> t, int size) {
		Session session = this.sessionFactory.getCurrentSession();
		for(int i = 0; i < t.size(); i++){
			logger.debug("batchInsert now");
			session.save(t.get(i));
			if(i % size == 0){
				session.flush();
				session.clear();
			}
		}
	}
	
	@Override
	public void batchUpdate(List<T> t, int size) {
		Session session = this.sessionFactory.getCurrentSession();
		for(int i = 0; i < t.size(); i++){
			session.update(t.get(i));
			if(i % size == 0){
				session.flush();
				session.clear();
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllByLimit(Class<T> clazz, int firstRow, int rows) {
		String hql = "FROM "+clazz.getSimpleName();
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql); 
		query.setFirstResult(firstRow);   
		query.setMaxResults(rows);
		return (List<T>)query.list();
	}

}
