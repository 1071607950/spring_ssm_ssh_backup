package com.city.oa.mvcstarter;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.city.oa.config.SpringAppConfigForSSM;
import com.city.oa.config.SpringMVCConfig;
//配置spring MVC方式02
//Spring MVC启动类，配置DispatcherServlet和Root and Servlet IoC容器
//public class SpringMVCStarter extends AbstractAnnotationConfigDispatcherServletInitializer 
public class SpringMVCStarterWithAbstractAnnotationConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
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
		return new String[] {"*.mvc"};
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
	//配置启用Servlet3.0的文件上传机制和StandardServletMultipartResolver文件解析器
	//通过设置自定义的注册项目
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		 final String LOCATION = "D:/temp"; // 删除文件的临时存储目录
		 final long MAX_FILE_SIZE = 5242880; // 5MB : 最大文件大小限制.
		 final long MAX_REQUEST_SIZE = 20971520; // 20MB : 请求数据的限制，包含上传文件.
		 final int FILE_SIZE_THRESHOLD = 0; //上传文件写入磁盘的大小阈值，当大于此数值时，文件就会保存到磁盘上。否则会在内存缓存
		 //创建上传配置项目对象
		 MultipartConfigElement multipartConfigElement = new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
	     //注册文件上传配置
		 registration.setMultipartConfig(multipartConfigElement);
		 System.out.println("启用Servlet3.0内置文件上传机制");
	}
	
}
