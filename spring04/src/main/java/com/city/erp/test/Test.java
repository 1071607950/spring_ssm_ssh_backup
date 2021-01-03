package com.city.erp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.city.erp.config.SpringConfig;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;

//测试Spring应用
public class Test {

	private static ApplicationContext ac;
	public static void main(String[] args) {
		ac = new ClassPathXmlApplicationContext("springcontext.xml");
		//使用Java配置方式
		//ac=new AnnotationConfigApplicationContext(SpringConfig.class);
		//取得Spring IOC容器管理的部门业务对象
		IProductService ps= ac.getBean("productService",IProductService.class);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		ProductModel pm=new ProductModel();
		pm.setName("苹果");
		pm.setPrice(1.0);
		pm.setQty(1000);
		try {
			pm.setDate(sdf.parse("2020-01-01"));
			ps.add(pm);
			for(ProductModel list:ps.getListByAll()) {
				System.out.println("编号:"+list.getNo()+",名称:"+list.getName());
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
