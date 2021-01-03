package com.city.oa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.city.oa.config.AppConfigForSSH;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IEmployeeService;

//测试Spring应用
public class Test {

	private static ApplicationContext ac;
	public static void main(String[] args) {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//使用Java配置方式
		//ac=new AnnotationConfigApplicationContext(AppConfigForSSH.class);
		//取得Spring IOC容器管理的部门业务对象
		IEmployeeService es= ac.getBean("employeeService",IEmployeeService.class);
		EmployeeModel em=new EmployeeModel();
		em.setId("7");
		em.setPass("12345");
		em.setName("张三");
		em.setAge(22);
		em.setSalary(5000);
		
		try {
			es.add(em);
			System.out.println(es.getById("1").getName());
			
			for(EmployeeModel list:es.getListByAgeScope(20, 30)) {
				System.out.println("账号:"+list.getId()+",姓名:"+list.getName()+",年龄:"+list.getSalary()+",工资:"+list.getSalary());
			}
			
			for(EmployeeModel list:es.getListByAllWithPage(2, 3)) {
				System.out.println("账号:"+list.getId()+",姓名:"+list.getName()+",年龄:"+list.getSalary()+",工资:"+list.getSalary());
			}
			
			System.out.println("汇总工资:"+es.getTotalSalaryByAll());
			
			System.out.println("平均年龄"+es.getAvgAgeByAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
