package com.paric.asset.other;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-test.xml","classpath*:spring/spring-hibernate-test.xml"})
@Transactional
public class BaseTest {
	protected static final Logger logger = Logger.getLogger(BaseTest.class);
	
	@Test
	public void test_1(){
		System.out.println("------");
	}
	
}
