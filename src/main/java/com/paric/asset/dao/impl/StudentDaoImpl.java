package com.paric.asset.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.paric.asset.dao.StudentDao;
import com.paric.asset.model.Student;

@Repository("studentDao")
public class StudentDaoImpl extends BaseCharacterDaoImpl<Student> implements StudentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> loadStudentTable(String teacherName, String instituteName,String majorName,String klassName, int pageNumber, int pageSize) {
		String hql;
		hql = "SELECT s.userno,s.name,s.gender,s.klass.name FROM Student s";
		if(StringUtils.isNotBlank(teacherName)){
			hql += " LEFT JOIN s.courseList.teacher t WHERE t.name='" + teacherName + "'";
		} else {
			hql += " WHERE 1=1";
		}
		if(!klassName.equals("查看全部")){
			if(klassName.equals("全部")){
				hql += " AND s.klass.major.institute.name='" + instituteName +"' AND s.klass.major.name='" + majorName + "'";
			} else{
				hql += " AND s.klass.major.institute.name='" + instituteName +"' AND s.klass.major.name='" + majorName + "' AND s.klass.name='" + klassName + "'";
			}
		}
		logger.debug(hql);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	@Override
	public int getStudentTableRows(String teacherName, String instituteName, String majorName, String klassName) {
		String hql;
		hql = "SELECT COUNT(*) FROM Student s";
		if(StringUtils.isNotBlank(teacherName)){
			hql += " LEFT JOIN s.courseList.teacher t WHERE t.name='" + teacherName + "'";
		} else {
			hql += " WHERE 1=1";
		}
		if(!klassName.equals("查看全部")){
			if(klassName.equals("全部")){
				hql += " AND s.klass.major.institute.name='" + instituteName +"' AND s.klass.major.name='" + majorName + "'";
			} else{
				hql += " AND s.klass.major.institute.name='" + instituteName +"' AND s.klass.major.name='" + majorName + "' AND s.klass.name='" + klassName + "'";
			}
		}
		logger.debug(hql);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		int total = (new Integer(query.uniqueResult().toString())).intValue();
		return total;
	}

	@Override
	public Student getStuInfoData(String keyWord) {
		String hql = "FROM Student WHERE userno='" + keyWord + "' OR name='" + keyWord + "'";
		logger.debug(hql);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		Student student = (Student) query.list().get(0);
		return student;
	}

}
