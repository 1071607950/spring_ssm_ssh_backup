package com.city.erp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//Spring MVC DispatcherServlet级别IoC容器配置类
@Configuration
@ComponentScan(basePackages= {"com.city.erp"})
@EnableWebMvc
public class SpringMVCConfig {
	//设置JSP结果解析器
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/"); 
		resolver.setSuffix(".jsp" );
		resolver.setRequestContextAttribute("requestContext"); 
		return resolver;
	}
	//文件上传处理解析器
	
	//JSON解析器
	
}