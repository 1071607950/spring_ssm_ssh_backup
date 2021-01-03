package com.city.oa.config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.city.oa.interceptor.ControllerInterceptor;
import com.city.oa.interceptor.UserLoginCheckInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
//Spring MVC DispatcherServlet级别IoC容器配置类
@Configuration
@ComponentScan(basePackages= {"com.city.oa"})
@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer{
	//设置JSP结果解析器
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/"); 
		resolver.setSuffix(".jsp" );
		resolver.setRequestContextAttribute("requestContext"); 
		System.out.println("Spring MVC配置类，JSP解析器。。。");
		return resolver;
	}
	//文件上传处理解析器StandardServletMultipartResolver
	/*
	@Bean
    public MultipartResolver multipartResolver() throws IOException
    {
    	return new StandardServletMultipartResolver();
    }
    */
	
	//(1)配置使用Apache Common Upload框架的文件解析器
	/*
	@Bean
	public CommonsMultipartResolver multipartResolver() throws Exception{
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSize(4000000);
		resolver.setDefaultEncoding("UTF-8");
		return resolver;
	}
	*/
		
	//JSON解析器,定制JSON日期转换类型
	/*
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
				.indentOutput(true)
				.dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		List<MediaType> list = new ArrayList<MediaType>();
	   	list.add(MediaType.APPLICATION_JSON_UTF8);
	   	MappingJackson2HttpMessageConverter convert=new MappingJackson2HttpMessageConverter(builder.build());
	   	convert.setSupportedMediaTypes(list);
	   	converters.add(convert);
	}
	*/
	
	
	//注册Controller拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ControllerInterceptor());
		//registry.addInterceptor(new UserLoginCheckInterceptor()).addPathPatterns("/employee/**");
		
		System.out.println("注册拦截器。。。");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
        registry.addMapping("/**").allowedOrigins("*");
	}

	
}
