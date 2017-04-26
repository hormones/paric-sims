package com.paric.asset.other;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
import com.paric.asset.service.StudentService;

import net.sf.json.JSONObject;

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
	private StudentService studentService;
	
	@Autowired
	private LoginService loginService;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseCharacterService baseCharacterService;
	
	//@Autowired
	//private StudentDao studentDao;
	
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
		logger.debug(administrator.getName());
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
		logger.debug(teacher.getName());
	}
	
	//插入学院和专业
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_major(){
		JSONObject jsonObject = new JSONObject();
	}
	
	//插入一个班级
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_klass(){
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Teacher teacher = (Teacher) baseDao.findById(Teacher.class, 2);
		teacherList.add(teacher);
		Klass klass = new Klass();
		klass.setName("一班");
		baseDao.save(klass);
	}
	
	//插入二十位学生
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_student20(){
		Klass klass = (Klass) baseDao.findById(Klass.class, 3);
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Teacher teacher = (Teacher) baseDao.findById(Teacher.class, 2);
		teacherList.add(teacher);
		for(int i=1;i<=20;i++){
			Student student = new Student();
			student.setName("王小二"+i);
			student.setUserno("201600"+i);
			student.setUserpwd("123456");
			student.setStusex("男");
			student.setStubirth(Date.valueOf("1995-11-11"));
			student.setStucomefrom("江苏省无锡市");
			student.setStuhomeaddress("江苏省无锡市");
			student.setStunationality("汉族");
			student.setStuemail("123456@abc.com");
			student.setStuIDnumber("123456789987654321");
			student.setKlass(klass);
			baseDao.save(student);
		}
		
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
	
	//查看以班级为单位的学生信息
	@Test
	@Rollback(true)
	public void test_JSON(){
		String data = studentService.loadStudentTable(null, "电气与信息工程学院", "电子信息工程", "一班", 1, 10);
		System.out.println("结果: "+data);
	}
	
}
