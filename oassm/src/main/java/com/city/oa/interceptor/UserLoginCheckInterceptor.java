package com.city.oa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
//用户登录检查过滤器
public class UserLoginCheckInterceptor implements HandlerInterceptor {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
       
		System.out.println("登录检查拦截器预处理....");
		HttpSession session=request.getSession();
		if(session==null||session.getAttribute("user")==null) {
			response.sendRedirect("/oassm/login.jsp");
			return false;
		}
		else {
			return true;
		}
    }
}
