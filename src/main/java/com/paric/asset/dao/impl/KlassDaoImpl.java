package com.paric.asset.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.paric.asset.dao.KlassDao;
import com.paric.asset.model.Klass;

@Repository("klassDao")
public class KlassDaoImpl extends BaseDaoImpl<Klass> implements KlassDao {

	@Override
	public Klass findKlassByName(String instituteName, String majorName, String klassName) {
		String hql = "FROM Klass k WHERE 1=1";
		hql += " AND k.major.institute.name='" + instituteName + "'";
		hql += " AND k.major.name='" + majorName + "'";
		hql += " AND k.name='" + klassName + "'";
		logger.debug(hql);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list().size()>0){
			return (Klass) query.list().get(0);
		}
		return null;
	}

}