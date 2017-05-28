package com.paric.asset.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.paric.asset.dao.AnnouncementDao;
import com.paric.asset.model.Announcement;

@Repository("announcementDao")
public class AnnouncementDaoImpl extends BaseDaoImpl<Announcement> implements AnnouncementDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> loadAnnouncementTable(Integer pageNumber, Integer pageSize) {
		String hql = "SELECT a.id,a.name,a.administrator.name,a.modifyTime FROM Announcement a";
		logger.debug(hql);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public int getAnnouncementTableRows() {
		String hql = "SELECT COUNT(*) FROM Announcement a";
		logger.debug(hql);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		int total = (new Integer(query.uniqueResult().toString())).intValue();
		return total;
	}

}
