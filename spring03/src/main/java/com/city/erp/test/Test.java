package com.city.erp.test;

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
		//ac = new ClassPathXmlApplicationContext("springcontext.xml");
		//使用Java配置方式
		ac=new AnnotationConfigApplicationContext(SpringConfig.class);
		//取得Spring IOC容器管理的部门业务对象
		IProductService ps= ac.getBean("productService",IProductService.class);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		ProductModel pm=new ProductModel();
		pm.setName("苹果");
		pm.setPrice(1.0);
		pm.setQty(1000);
		
		try {
			
			pm.setDate(sdf.parse("2000-01-01"));
			ps.add(pm);
			System.out.println("2.取得产品名称中包含key的产品列表");
			for(ProductModel list:ps.getListBySearchName("汁")) {
				System.out.println("编号:"+list.getNo()+"名称:"+list.getName());
			}
			
			System.out.println("3.取得产品日期在start和end之间的产品列表");
			for(ProductModel list:ps.getListByDateScope(sdf.parse("2000-01-01"), sdf.parse("2010-12-31"))) {
				System.out.println("编号:"+list.getNo()+" 名称:"+list.getName()+" 生产日期"+list.getDate());
			}
			
			System.out.println("4.取得产品单价在low和high之间的产品列表");
			for(ProductModel list:ps.getListByPriceScope(1, 2)) {
				System.out.println("编号:"+list.getNo()+" 名称:"+list.getName()+" 价格"+list.getPrice());
			}
			
			System.out.println("5.所有的产品的汇总金额:"+ps.getTotalAmountByAll());
			System.out.println("6.取得日期在start和end之间的产品个数"+ps.getCountByDateScope(sdf.parse("2000-01-01"), sdf.parse("2010-12-31")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
