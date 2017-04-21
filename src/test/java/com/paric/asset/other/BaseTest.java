package com.paric.asset.other;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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
import com.paric.asset.model.Klass;
import com.paric.asset.model.Student;
import com.paric.asset.model.Teacher;
import com.paric.asset.service.BaseCharacterService;
import com.paric.asset.service.LoginService;

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
	
	@Test
	@Rollback(false)
	public void test_0(){
		System.out.println("-------");
	}
	
	//插入一位管理员
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_administrator(){
		Administrator administrator = new Administrator();
		administrator.setName("王大锤");
		administrator.setUserno("admin");
		administrator.setUserpwd("123456");
		baseDao.save(administrator);
	}
	
	//插入一个班级
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_klass(){
		Klass klass = new Klass();
		klass.setName("一班");
		klass.setKlassCollege("计算机科学与工程");
		klass.setKlassDepartment("计算机科学与技术");
		klass.setKlassGrade("2016");
		baseDao.save(klass);
	}
	
	//插入一位教师
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_teacher(){
		Teacher teacher = new Teacher();
		teacher.setName("王二锤");
		teacher.setUserno("60001");
		teacher.setUserpwd("123456");
		baseDao.save(teacher);
	}
	
	//插入一位学生
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_student(){
		Student student = new Student();
		student.setName("王小二");
		student.setUserno("2017001");
		student.setUserpwd("123456");
		student.setStusex("男");
		student.setStuemail("123456@abc.com");
		student.setStuIDnumber("123456789987654321");
		baseDao.save(student);
	}
	
	//角色登录
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	@Rollback(true)
	public void test_login(){
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
	
	//通过学号查找学生
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(true)
	public void test_findByUserno(){
		BaseCharacter character = (BaseCharacter) baseCharacterService.findByUserno(Student.class, "2017001");
		if(character!=null){
			logger.debug("结果是："+((Student)character).getStuemail());
		}
	}
	
}
