package com.paric.asset.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paric.asset.model.BaseCharacter;
import com.paric.asset.service.BaseCharacterService;
import com.paric.asset.service.BaseService;

@Controller
@RequestMapping("/property.do")
public class BaseController<T> {
	
	protected static final Logger logger = Logger.getLogger(BaseController.class);
	
	@Resource(name="baseService")
	protected BaseService<T> baseService;
	
	protected BaseCharacter baseCharacter;
	
	@SuppressWarnings("rawtypes")
	protected BaseCharacterService baseCharacterService;
	
	@InitBinder
	protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(Double.class,new CustomNumberEditor(Double.class,true));
	}
	
	@SuppressWarnings("unchecked")
	@ModelAttribute
	protected void getCurrentLoginAccount(HttpServletRequest request) throws Exception{
		baseCharacter = (BaseCharacter) request.getSession().getAttribute("loginUser");
		if(null != baseCharacter){
			baseCharacter = (BaseCharacter) baseCharacterService.findById(BaseCharacter.class, baseCharacter.getId());
		}
	}
	
}
