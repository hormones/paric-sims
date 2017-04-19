package com.paric.asset.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.paric.asset.dao.LoginDao;
import com.paric.asset.model.BaseCharacter;
import com.paric.asset.model.Student;

@Repository("loginDao")
public class LoginDaoImpl extends BaseDaoImpl<BaseCharacter> implements LoginDao {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BaseCharacter> T login(String userno, String userpwd, Class<T> clazz) {
		String hql = "FROM "+clazz.getSimpleName()+" WHERE userno='"+userno+"' AND userpwd='"+userpwd+"'";
		logger.debug(hql);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list().size()>0){
			return (T) query.list().get(0);
		}
		return null;
	}

	@Override
	public boolean pwdRevision(String userno, String newPassword, String identity) {
//		SqlSession session = getSqlSession();
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("user", user);
//		map.put("newPassword", newPassword);
//		if(identity.equals("administrator")){
//			int result= session.update("com.sims.mapper.loginMapper.administratorRevision",map);
//			if(result!=0){
//				return true;
//			}
//		}else if(identity.equals("student")){
//			int result= session.update("com.sims.mapper.loginMapper.studentRevision",map);
//			if(result!=0){
//				return true;
//			}
//		}else if(identity.equals("teacher")){
//			int result= session.update("com.sims.mapper.loginMapper.teacherRevision",map);
//			if(result!=0){
//				return true;
//			}
//		}
		return false;
	}

	@Override
	public List<Student> stuSearch(String userno) {
//		List<Student> list = new ArrayList<Student>();
//		SqlSession session = getSqlSession();
//		Student student= session.selectOne("com.sims.mapper.loginMapper.studentSearch",stuno);
//		list.add(student);
		return null;
	}

}
