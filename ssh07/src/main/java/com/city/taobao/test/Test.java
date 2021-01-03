package com.city.taobao.test;

import java.text.SimpleDateFormat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.city.taobao.config.SpringConfig;
import com.city.taobao.model.OrderModel;
import com.city.taobao.service.IOrderService;
//测试Spring应用
public class Test {
	private static ApplicationContext ac;
	public static void main(String[] args) {
		//创建Spring IOC容器对象
		//使用XML配置文件
		//ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//使用Java配置方式
		ac=new AnnotationConfigApplicationContext(SpringConfig.class);
		//取得Spring IOC容器管理的部门业务对象
		IOrderService os=ac.getBean("orderService",IOrderService.class);
		try {
			for(OrderModel list:os.getListByPriceScope(1, 2)) {
				System.out.println("编号为:"+list.getNo()+",价格:"+list.getPrice());
			}
			
			for(OrderModel list:os.getListByPriceWithPage(1, 2, 2, 2)) {
				System.out.println("编号为:"+list.getNo()+",价格:"+list.getPrice());
			}
			
			System.out.println("订单数量为:"+os.getCountByPrice(1, 2));
			
			System.out.println("页数为:"+os.getPageCountByPrice(1, 5, 4));
			
			for(OrderModel list:os.getListBySearchCustomerName("王")) {
				System.out.println("编号为:"+list.getNo()+",姓名:"+list.getName());
			}

			System.out.println("总金额:"+os.getTotalAmountByDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01"), new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-31")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
