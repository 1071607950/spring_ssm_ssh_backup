package com.city.erp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.city.erp.config.AppConfigForSSH;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;

//测试Spring应用
public class Test {

	private static ApplicationContext ac;
	public static void main(String[] args) {
		//ac = new ClassPathXmlApplicationContext("contextForSSH.xml");
		//使用Java配置方式
		ac=new AnnotationConfigApplicationContext(AppConfigForSSH.class);
		//取得Spring IOC容器管理的部门业务对象
		IProductService ps= ac.getBean("productService",IProductService.class);
		ProductModel pm=new ProductModel();
		pm.setName("葡萄");
		pm.setPrice(1);
		pm.setQty(10);
		try {
			ps.add(pm);
			System.out.println(ps.checkProductExist(1));
			for(ProductModel list:ps.getListByPriceScope(1, 2)) {
				System.out.println("编号:"+list.getNo()+"单价:"+list.getPrice());
			}
			System.out.println("加权平均单价"+ps.getAvgPrice());
			for(ProductModel list:ps.getListByCondition("苹果", 1, 2)) {
				System.out.println("编号:"+list.getNo()+"名称:"+list.getName());
			}
			System.out.println("个数:"+ps.getCountByCondition("苹果", 1, 2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
