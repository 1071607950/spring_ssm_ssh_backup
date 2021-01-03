package com.city.oa.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.city.oa.config.SpringConfig;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IEmployeeService;

//测试Spring应用
public class Test {

	private static ApplicationContext ac;
	public static void main(String[] args) {
		//ac = new ClassPathXmlApplicationContext("context.xml");
		//使用Java配置方式
		ac=new AnnotationConfigApplicationContext(SpringConfig.class);
		//取得Spring IOC容器管理的部门业务对象
		IEmployeeService es= ac.getBean("employeeService",IEmployeeService.class);
		EmployeeModel em=new EmployeeModel();
		em.setId("6");
		em.setPass("45678");
		em.setName("丙");
		em.setAge(35);
		em.setSalary(5000);

		try {
			//es.add(em);
			System.out.println("账号密码是否正确:"+es.validate("1", "123456"));
			List<EmployeeModel> lists=es.getListByAgeScope(20, 25);
			for(EmployeeModel list:lists) {
				System.out.println("姓名:"+list.getName()+",年龄:"+list.getAge());
			}
			List<EmployeeModel> lists1=es.getListByAllWithPage(3, 1);
			for(EmployeeModel list1:lists1) {
				System.out.println(list1.getName());
			}
			
			System.out.println("汇总工资:"+es.getTotalSalaryByAll());
			System.out.println("平均年龄:"+es.getAvgAgeByAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
