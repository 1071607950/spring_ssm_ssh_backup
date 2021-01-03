package com.city.erp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.city.erp.config.AppConfig;

import com.city.erp.service.IProductService;

//测试Spring应用
public class Test {

	public static void main(String[] args) {
		//创建Spring IOC容器对象
		//使用XML配置文件
		ApplicationContext ac=new ClassPathXmlApplicationContext("context.xml");
		//使用Java配置方式
		ApplicationContext ac1=new AnnotationConfigApplicationContext(AppConfig.class);
		//取得Spring IOC容器管理的部门业务对象
		IProductService ds= ac.getBean("productService",IProductService.class);
		IProductService ds1= ac1.getBean("productService",IProductService.class);
		
		//System.out.println(ac.containsBean("departmentService"));
		//System.out.println(ds==ds01);
		try {
			ds.add("1", "苹果", "1", 11.1);
			ds1.add("2", "香蕉", "2", 22.2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
