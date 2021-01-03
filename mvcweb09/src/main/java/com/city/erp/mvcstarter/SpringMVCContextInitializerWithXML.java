package com.city.erp.mvcstarter;

import javax.servlet.Filter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
//读取XML Spring IoC容器配置文件的Web MVC启动类
//可省略web.xml的配置
//public class SpringMVCContextInitializerWithXML extends AbstractDispatcherServletInitializer
public class SpringMVCContextInitializerWithXML{

	//启动Root级别的IoC容器
	protected WebApplicationContext createRootApplicationContext() {
		System.out.println("Root Context XML方式。。。。");
		XmlWebApplicationContext cxt = new XmlWebApplicationContext();
		cxt.setConfigLocation("classpath:SpringContext.xml");
		return cxt;
	}
	//启动DispatcherServlet级别的IoC容器
	protected WebApplicationContext createServletApplicationContext() {
		System.out.println("Servlet级别 Context XML方式。。。。");
		XmlWebApplicationContext cxt = new XmlWebApplicationContext();
		cxt.setConfigLocation("classpath:spring-mvc.xml");
		return cxt;
	
	}
	//设置DispatcherServlet的请求地址
	protected String[] getServletMappings() {
		return new String[] {"*.do"};
	}

	//配置DispatchServlet的过滤器
	protected Filter[] getServletFilters() {
		//配置UTF-8字符编码集过滤器
		CharacterEncodingFilter cef = new CharacterEncodingFilter();
		cef.setEncoding("UTF-8");
		cef.setForceEncoding(true);
		System.out.println("DispatchServlet的过滤器");
		return new Filter[]{cef,new HiddenHttpMethodFilter()};
	}
		
	
}
