package com.city.oa.mvcstarter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
//Spring MVC启动类，使用实现接口WebApplicationInitializer
//编程方式配置DispactherServlet
//public class SpringMVCStarterWithWebApplicationInitializer implements WebApplicationInitializer

public class SpringMVCStarterWithWebApplicationInitializer {
	//@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//设置Root级别IoC容器的启动监听器
		servletContext.setInitParameter("contextClass","org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
		servletContext.setInitParameter("contextConfigLocation","com.city.oa.config.SpringAppConfigForSSM");
		servletContext.addListener(new org.springframework.web.context.ContextLoaderListener());
				
		//创建Spring MVC前端控制器DispatcherServlet
		ServletRegistration.Dynamic registration =servletContext.addServlet("app", new DispatcherServlet());
		registration.setLoadOnStartup(1);
		//设置请求地址
		registration.addMapping("*.mvc");
		//设置IoC容器的实现类，使用读取配置类方式的实现类
		registration.setInitParameter("contextClass","org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
		//设置读取的IoC容器的配置类
		registration.setInitParameter("contextConfigLocation","com.city.oa.config.SpringMVCConfig");
		
		System.out.println("Spring 启动配置类（使用WebApplicationInitializer）。。。");
		//配置另外一个REST API使用的DispatcherServlet
		
		
		
		
	}
}
