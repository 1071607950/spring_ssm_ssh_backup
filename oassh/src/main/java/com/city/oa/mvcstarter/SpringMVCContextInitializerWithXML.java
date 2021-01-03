package com.city.oa.mvcstarter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
//读取XML Spring IoC容器配置文件的Web MVC启动类
//可省略web.xml的配置
//public class SpringMVCContextInitializerWithXML extends AbstractDispatcherServletInitializer
public class SpringMVCContextInitializerWithXML  {

	//启动Root级别的IoC容器
	protected WebApplicationContext createRootApplicationContext() {
		System.out.println("Root Context XML方式。。。。");
		XmlWebApplicationContext cxt = new XmlWebApplicationContext();
		cxt.setConfigLocation("classpath:applicationcontextforssm.xml");
		return cxt;
	}
	//启动DispatcherServlet级别的IoC容器
	protected WebApplicationContext createServletApplicationContext() {
		System.out.println("Servlet级别 Context XML方式。。。。");
		XmlWebApplicationContext cxt = new XmlWebApplicationContext();
		cxt.setConfigLocation("classpath:springmvccontext.xml");
		return cxt;
	
	}
	//设置DispatcherServlet的请求地址
	protected String[] getServletMappings() {
		return new String[] {"*.mvc"};
	}
}
