package com.paric.asset.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.paric.asset.model.BaseCharacter;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		BaseCharacter loginUser = (BaseCharacter) request.getSession().getAttribute("loginUser"); 
		String queryParam = request.getQueryString();
        if(queryParam.equals("dispatch=login") || loginUser!=null){
            return true;
        } else {
        	response.sendRedirect(request.getContextPath()+"/login.jsp");
        	return false;
        }
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
					throws Exception {
	}
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}
}
