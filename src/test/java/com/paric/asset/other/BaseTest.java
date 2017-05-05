package com.paric.asset.other;

import java.sql.Date;
import java.util.Iterator;

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

import com.paric.asset.model.Administrator;
import com.paric.asset.model.Announcement;
import com.paric.asset.model.BaseCharacter;
import com.paric.asset.model.Institute;
import com.paric.asset.model.Klass;
import com.paric.asset.model.Major;
import com.paric.asset.model.Student;
import com.paric.asset.model.Teacher;
import com.paric.asset.service.AnnouncementService;
import com.paric.asset.service.BaseCharacterService;
import com.paric.asset.service.BaseService;
import com.paric.asset.service.KlassService;
import com.paric.asset.service.StudentService;
import com.paric.asset.util.ReadFileUtil;

import net.sf.json.JSONArray;
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
	private BaseService baseService;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseCharacterService baseCharacterService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AnnouncementService announcementService;
	
	@Autowired
	private KlassService klassService;
	
	@Test
	@Rollback(false)
	public void test_0(){
		System.out.println("------");
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
		baseService.add(administrator);
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
		baseService.add(teacher);
		logger.debug(teacher.getName());
	}
	
	//插入学院、专业和班级
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_klasses(){
		String filePath=this.getClass().getClassLoader().getResource("./baseData/instituteAndMajor.json").getPath(); //获得文件路径
		String JsonContext = ReadFileUtil.getInstance().ReadFile(filePath); //读取文件
		JSONArray instituteArray = JSONArray.fromObject(JsonContext); //将文件解析为JSONArray
		for (int i=0; i< instituteArray.size(); i++ ) {
			JSONObject json_institute = (JSONObject) instituteArray.get(i);
			Iterator<String> iterator_institute = json_institute.keys();
			String instituteCode = null,instituteName = null;
			while(iterator_institute.hasNext()){
				String institute_key = iterator_institute.next();
				if(institute_key.equals("学院代号")){
					instituteCode = json_institute.getString(institute_key);
				} else {
					instituteName = institute_key;
					//查看数据库中学院名称是否已存在
					Institute instituteInDatabase = (Institute) baseService.findByName(Institute.class, instituteName); 
				    if(null == instituteInDatabase){
				    	//如果数据库中学院名称不存在
				    	Institute institute = new Institute();
				    	institute.setName(instituteName);
				    	institute.setCode(instituteCode);
				    	baseService.add(institute); //插入学院
				    	logger.debug("学院插入成功: "+ instituteName+instituteCode);
				    } else {
						System.out.println("学院: "+instituteName+" 已存在");
					}
				    //重新从数据库获得学院，学院存在且相关专业不存在才能执行插入操作
			    	instituteInDatabase = (Institute) baseService.findByName(Institute.class, instituteName); 
			    	//如果数据库中学院名称存在
			    	if(null != instituteInDatabase){
			    		//根据学院获得专业，然后遍历json_major
			    		JSONArray majorArray = (JSONArray) json_institute.get(instituteName);
			    		for (int j=0; j< majorArray.size(); j++ ) {
			    			JSONObject json_major = (JSONObject) majorArray.get(j);
			    			Iterator<String> iterator_major = json_major.keys();
			    			String majorCode = null,majorName = null;
			    			while(iterator_major.hasNext()){
			    				String major_key = iterator_major.next();
			    				if(major_key.equals("专业代号")){
			    					majorCode = json_major.getString(major_key);
			    				} else {
			    					majorName = major_key;
			    					Major majorInDatabase = (Major) baseService.findByName(Major.class, majorName); //查看数据库中专业名称是否已存在
			    					if(null == majorInDatabase){
			    				    	//如果数据库中专业名称不存在
			    						Major major = new Major();
					    				major.setName(majorName);
					    				major.setInstitute(instituteInDatabase);
					    				major.setCode(majorCode);
					    				baseService.add(major); //插入专业
					    				logger.debug("专业插入成功: "+ majorName);
			    				    } else {
			    						System.out.println("专业: "+majorName+" 已存在");
			    					}
			    					majorInDatabase = (Major) baseService.findByName(Major.class, majorName); //重新从数据库获得专业，学院和专业都存在且相关班级不存在才能执行插入操作
					    			//如果数据库中专业名称存在
					    			if(null != majorInDatabase){
					    				// 根据专业获得班级，然后遍历json_klass
					    				JSONArray json_klass = (JSONArray) json_major.get(majorName);
					    				for (int k=0; k< json_klass.size(); k++ ) {
					    					String klassName = (String) json_klass.get(k); //获得班级名称
					    						Klass klassInDatabase = klassService.findKlassByName(instituteName, majorName, klassName);
					    						//如果数据库中班级名称不存在
					    						if(null == klassInDatabase){
					    							Klass klass = new Klass();
					    							klass.setName(klassName);
					    							klass.setGrade("2016");
					    							klass.setMajor(majorInDatabase);
					    							klass.setCode(majorCode+k);
					    							baseService.add(klass); //插入班级
					    							logger.debug("班级插入成功: "+ klassName);
					    						} else {
					    							System.out.println("班级: "+klassName+" 已存在");
					    						}
					    				}
					    			} else {
					    				System.out.println(majorName+" 不存在，无法插入相关班级");
					    			}
			    				}
			    			}
			    		}
			    	} else {
			    		System.out.println(instituteName+" 不存在，无法插入相关专业");
			    	}
				}
			}
		}
	}
	
	
	//插入学生
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_students(){
		String filePath=this.getClass().getClassLoader().getResource("./baseData/studentList.json").getPath(); //获得文件路径
		String JsonContext = ReadFileUtil.getInstance().ReadFile(filePath); //读取文件
		JSONArray sudentsArray = JSONArray.fromObject(JsonContext); //将文件解析为JSONArray
		for (int i=0; i< sudentsArray.size(); i++ ) {
			JSONObject json_student = (JSONObject) sudentsArray.get(i);
			Klass klass = klassService.findKlassByName(json_student.getString("instituteName"), json_student.getString("majorName"), json_student.getString("klassName"));
			if(null != klass){
				Student student = new Student();
				Student studentInDatabase = studentService.findByUserno(Student.class, json_student.getString("userno"));
				if(null == studentInDatabase){
					student.setName(json_student.getString("name"));
					student.setUserno(json_student.getString("userno"));
					student.setUserpwd(json_student.getString("userno"));
					student.setGender(json_student.getString("gender"));
					student.setBirthday(Date.valueOf(json_student.getString("birthday")));
					student.setStuintime(Date.valueOf(json_student.getString("stuintime")));
					student.setStucomefrom(json_student.getString("stucomefrom"));
					student.setHomeaddress(json_student.getString("homeaddress"));
					student.setNationality(json_student.getString("nationality"));
					student.setEmail(json_student.getString("email"));
					student.setIdNumber(json_student.getString("idNumber"));
					student.setPolitics(json_student.getString("politics"));
					student.setKlass(klass);
					baseService.add(student);
					logger.debug(json_student.getString("name")+" 插入成功");
				} else {
					System.out.println(json_student.getString("name")+" 已存在");
				}
			} else {
				System.out.println("班级不存在，无法插入学生");
			}
		}
	}
	
	//插入公告
	@SuppressWarnings("unchecked")
	@Test
	@Rollback(false)
	public void test_announcement(){
		Announcement announcement = new Announcement();
		Administrator administrator = (Administrator) baseCharacterService.findByName(Administrator.class, "王大锤");
		announcement.setName("创建文明校园倡议书1");
		announcement.setContent("2017年的第一缕春风和朝阳，伴随着我们一起来到了这个美丽的校园。春风吹绿了小草，绿树抽出了新枝，草坪、蓝天和一栋栋崭新的楼宇都成了校园里美丽的风景线。但你已经有多久没有见到清晨第一缕阳光？有多久不曾感受晨读的乐趣？是否曾为了多睡几分钟拎着早餐踩点进教室甚至迟到？");
		announcement.setModifyTime(new Date(System.currentTimeMillis()));
		announcement.setAdministrator(administrator);
		announcementService.add(announcement);
		logger.debug(announcement.getName());
	}
	
	//
	@Test
	@Rollback(false)
	public void test_course(){
		
	}
	
	//角色登录
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	@Rollback(true)
	public void test_login(){
		String identity = "Administrator",userno="admin";
		//String identity = "Teacher",userno="60001";
		//String identity = "Student",userno="20160001";
		String userpwd = "123456";
		Class clazz;
		try {
			clazz = Class.forName("com.paric.asset.model."+identity);
			BaseCharacter loginUser = (BaseCharacter) baseCharacterService.login(clazz, userno, userpwd);
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
	
	
	//查看以班级为单位的学生信息
	@Test
	@Rollback(true)
	public void test_JSON(){
		String data = studentService.loadStudentTable(null, "电气与信息工程学院", "电子信息工程", "一班", 1, 10);
		System.out.println("结果: "+data);
	}
	
}