package com.paric.asset.other;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.paric.asset.dao.BaseDao;
import com.paric.asset.model.Administrator;
import com.paric.asset.model.BaseCharacter;
import com.paric.asset.model.Student;
import com.paric.asset.model.Teacher;
import com.paric.asset.service.BaseCharacterService;
import com.paric.asset.service.LoginService;
import com.paric.asset.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring.xml","classpath*:spring/spring-hibernate.xml"})
@Transactional
public class BaseTest {
	
	protected static final Logger logger = Logger.getLogger(BaseTest.class);
	
	@Resource
	protected SessionFactory sessionFactory;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseDao baseDao;
	
	@Autowired
	private LoginService loginService;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseCharacterService baseCharacterService;
	
	@Autowired
	private StudentService studentService;
	
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_1(){
//		Administrator administrator = new Administrator();
//		administrator.setName("王大锤");
//		administrator.setUserno("admin");
//		administrator.setUserpwd("123456");
//		baseDao.save(administrator);
		System.out.println("----");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_2(){
		Teacher teacher = new Teacher();
		teacher.setName("王二锤");
		teacher.setUserno("60001");
		teacher.setUserpwd("123456");
		baseDao.save(teacher);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_3(){
		Student student = new Student();
		student.setName("王小二");
		student.setUserno("2017001");
		student.setUserpwd("123456");
		student.setStusex("男");
		student.setStuclass("一班");
		student.setStuemail("123456@abc.com");
		student.setStuIDnumber("123456789987654321");
		baseDao.save(student);
	}
	
	@Test
	@Rollback(true)
	public void test_4(){
		String hql = "FROM Administrator WHERE userno='admin' AND userpwd='123456'";
		logger.debug(hql);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Administrator> list = query.list();
		Long result = (Long) query.uniqueResult();
		for (Administrator administrator : list) {
			System.out.println(administrator.getName());
		}
		logger.debug("结果是："+result);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	@Rollback(true)
	public void test_5(){
		//String identity = "Administrator",userno="admin";
		String identity = "Teacher",userno="60001";
		//String identity = "Student",userno="2017001";
		String userpwd = "123456";
		Class clazz;
		try {
			clazz = Class.forName("com.paric.asset.model."+identity);
			BaseCharacter loginUser = loginService.login(userno, userpwd, clazz);
			if(loginUser!=null){
				String name = loginUser.getName();
				System.out.println(name);
				System.out.println("登陆通过...");
			} else{
				System.out.println("登陆失败...");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Rollback(true)
	public void test_6(){
		Student student = studentService.findByUserno(Student.class, "2017001");
		if(student!=null){
			logger.debug("结果是："+student.getStuclass());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(true)
	public void test_7(){
		BaseCharacter character = (BaseCharacter) baseCharacterService.findByUserno(Student.class, "2017001");
		if(character!=null){
			logger.debug("结果是："+((Student)character).getStuemail());
		}
	}
	
}
