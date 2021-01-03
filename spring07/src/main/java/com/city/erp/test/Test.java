package com.city.erp.test;

import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.city.erp.config.SpringAppConfigForSSM;
import com.city.erp.model.AreaModel;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;

public class Test {

	private static ApplicationContext ac;

	public static void main(String[] args) {
		//ac=new ClassPathXmlApplicationContext("context.xml");
		ac = new AnnotationConfigApplicationContext(SpringAppConfigForSSM.class);
		IProductService ps=ac.getBean("productService",IProductService.class);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		ProductModel pm=new ProductModel();
		pm.setName("葡萄");
		pm.setPrice(2);
		pm.setQty(100);
		try {
			pm.setDate(sdf.parse("2020-01-01"));
			ps.add(pm);
			ps.addAreas(1, new int[] {1,2});
			
			for(AreaModel am:ps.getAreaListByProduct(1)) {
				System.out.println("编号:"+am.getNo()+",名称:"+am.getName());
			}
			
			for(ProductModel list:ps.getProductListWithoutArea()) {
				System.out.println("编号:"+list.getNo()+",名称:"+list.getName());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
