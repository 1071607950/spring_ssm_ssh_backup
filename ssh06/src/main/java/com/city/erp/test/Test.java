package com.city.erp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.city.erp.config.SpringConfigForSSH;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;
//测试Spring应用
public class Test {
	private static ApplicationContext ac;
	public static void main(String[] args) {
		//创建Spring IOC容器对象
		//使用XML配置文件
		//ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//使用Java配置方式
		ac=new AnnotationConfigApplicationContext(SpringConfigForSSH.class);
		//取得Spring IOC容器管理的部门业务对象
		IProductService ps=ac.getBean("productService",IProductService.class);
		try {
			
			//1.增加
			//ps.add(2, "苹果", 1.0, 100);
			//2.修改
			ps.modify(3, "香蕉", 2, 2.0, 200);
			//3.修改单价
			ps.changePrice(3, 3.0);
			//4.取得单价
			System.out.println("产品的单价是:"+ps.getPriceByProduct(2));
			//6.取得指定编号的产品信息
			ProductModel pm=ps.getProduct(2);
			if(pm!=null)
				System.out.println("编号为:"+pm.getNo()+",产品的名称是:"+pm.getName()+",产品的类别名称:"+pm.getCategory().getName()+",产品单价:"+pm.getPrice()+",产品数量:"+pm.getQty());
			else
				System.out.println("产品不存在");
			//7.取得指定产品的金额
			System.out.println("指定产品的金额为:"+ps.getAmontByProduct(2));
			//8.取得指定类别的产品金额汇总
			System.out.println("指定类别总产品数量:"+ps.getTotalQTYByCategory(2));
			//9.检查指定的产品是否在指定的产品类别中
			System.out.println("是否在指定类别中:"+ps.checkProductInCategory(2, 2));
			System.out.println("是否在指定类别中:"+ps.checkProductInCategory(2, 3));
			//5.删除产品
			//ps.delete(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
