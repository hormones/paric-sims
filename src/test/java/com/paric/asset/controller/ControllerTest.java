package com.paric.asset.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/spring.xml","classpath*:spring/spring-mvc.xml","classpath*:spring/spring-hibernate.xml"})
@Transactional
public class ControllerTest {

	@Autowired  
    private WebApplicationContext wac;  
  
    private MockMvc mockMvc; 
    
    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();  
    } 
    
    @Test  
    public void testLogin() throws Exception {  
        mockMvc.perform((post("/character.do?dispatch=login")
        		.param("identity", "Administrator").param("userno", "admin").param("userpwd", "123456")))
        		//.andExpect(status().isOk()) 
                .andDo(print());
    }
}
