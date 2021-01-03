package com.city.oa.mvcstarter;

import javax.servlet.Filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import com.city.oa.config.SpringConfigForSSH;
import com.city.oa.config.SpringMVCConfig;


//通过继承AbstractDispatcherServletInitializer实现Spring MVC启动类
//public class SpringMVCContextInitializerWithJavaConfig extends AbstractDispatcherServletInitializer 
public class SpringMVCContextInitializerWithJavaConfig {

	//取得Root级别的IoC容器配置
	
	protected WebApplicationContext createRootApplicationContext() {
		AnnotationConfigWebApplicationContext applicationContext=new AnnotationConfigWebApplicationContext();
		applicationContext.register(SpringConfigForSSH.class);
		System.out.println("Spring MVC启动类，读取Root配置类");
		return applicationContext;
	}
	//取得DiapctherServlet级别的IoC容器配置
	
	protected WebApplicationContext createServletApplicationContext() {
		AnnotationConfigWebApplicationContext applicationContext=new AnnotationConfigWebApplicationContext();
		applicationContext.register(SpringMVCConfig.class);
		System.out.println("Spring MVC启动类，读取Serlvet级别配置类");
		return applicationContext;
		
	}
	//取得DispatcherServlet的请求地址
	
	protected String[] getServletMappings() {
		return new String[] {"*.mvc"};
	}
	//定义DispatcherServlet的过滤器
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter cef = new CharacterEncodingFilter();
		cef.setEncoding("UTF-8");
		cef.setForceEncoding(true);
		
		return new Filter[] {new HiddenHttpMethodFilter(), cef };
	}
	
	
}
