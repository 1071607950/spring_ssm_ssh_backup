package com.city.erp.mvcstarter;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.city.erp.config.SpringAppConfigForSSM;
import com.city.erp.config.SpringMVCConfig;
//配置spring MVC方式02
//Spring MVC启动类，配置DispatcherServlet和Root and Servlet IoC容器
//public class SpringMVCStarter extends AbstractAnnotationConfigDispatcherServletInitializer 
public class SpringMVCStarterWithAbstractAnnotationConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	//取得Root级别 IoC容器配置类
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {SpringAppConfigForSSM.class};
	}
	//取得Spring MVC DispatcherServlet级别IoC容器配置类
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Spring MVC启动类（AbstractAnnotationConfigDispatcherServletInitializer）。。。");
		return new Class<?>[] {SpringMVCConfig.class};
	}
	//设置Spring MVC DispatcherServlet的映射请求地址
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
