package com.paric.asset.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.paric.asset.model.BaseCharacter;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		BaseCharacter loginUser = (BaseCharacter) request.getSession().getAttribute("loginUser"); 
		String queryParam = request.getQueryString();
		if (!queryParam.equals("dispatch=login")) {
			if (null == loginUser) {
				if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ //如果是ajax请求，响应头会有x-requested-with  
					response.setHeader("sessionstatus", "timeout"); //在响应头设置session状态  
				}else{
					response.sendRedirect(request.getContextPath()+"/login.jsp");
				}
				return false;
			}
        }
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
					throws Exception {
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3) throws Exception {
	}
}
