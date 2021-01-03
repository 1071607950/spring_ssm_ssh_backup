package com.city.erp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;
import com.city.erp.service.impl.ProductServiceImpl;

public class Test {

	private static ApplicationContext ac;

	public static void main(String[] args) {
		ac = new ClassPathXmlApplicationContext("context.xml");
		IProductService ps=ac.getBean(ProductServiceImpl.class);
		ProductModel pm=new ProductModel();
		pm.setName("苹果");
		pm.setPrice(1);
		pm.setQty(100);
		try {
			ps.add(pm);
			pm.setNo(2);
			pm.setName("橘子");
			pm.setPrice(10);
			ps.modify(pm);
			
			pm.setNo(3);
			ps.delete(pm);
			System.out.println(ps.getByNo(1).getName());
			for(ProductModel list:ps.getListByAll()) {
				System.out.println("编号:"+list.getNo()+",名称:"+list.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
