package com.city.oa.test;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.city.oa.config.AppServiceConfig;
import com.city.oa.config.ApplicationConfig;
import com.city.oa.config.SpringAnnotationConfig;
import com.city.oa.config.SpringConfig;
import com.city.oa.config.SpringConfigForSSH;
import com.city.oa.model.DepartmentModel;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IDepartmentService;
import com.city.oa.service.IEmployeeService;

//测试Spring应用
public class TestSpring {

	public static void main(String[] args) {
		
		//创建Spring IOC容器对象
		//使用XML配置文件
		//ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontextaop.xml");
		//ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontextforssh.xml");
		//ApplicationContext ac=new ClassPathXmlApplicationContext("sshcontext.xml");
		
		
		//使用Java配置类方式
		//ApplicationContext ac=new AnnotationConfigApplicationContext(AppServiceConfig.class);
		//ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfigForSSH.class);
		ApplicationContext ac=new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
		
		
		//取得Spring IoC容器管理的部门业务对象
		//IDepartmentService ds=ac.getBean("departmentServiceWithSSH",IDepartmentService.class);
		//IDepartmentService ds01=ac.getBean("departmentService",IDepartmentService.class);
		
		//System.out.println(ds==ds01);
		
		/*
		DepartmentModel dm=new DepartmentModel();
		dm.setCode("YYY");
		dm.setName("YY部");
		*/
		
		IEmployeeService es=ac.getBean(IEmployeeService.class);
		
		
		
		
		try {
			//ds.add(dm);
			//DepartmentModel dm=ds.getByNo(1);
			//System.out.println(dm.getName());
			
			List<EmployeeModel> list=es.getListBySearchCondition("明", "", 0, 30, null, null);
			System.out.println(list.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		

	}

}
