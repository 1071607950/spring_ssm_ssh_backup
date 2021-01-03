package com.city.oa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.city.oa.config.SpringAppConfigForSSM;
import com.city.oa.model.DepartmentModel;
import com.city.oa.service.IDepartmentService;

public class Test02SSM {

	public static void main(String[] args) {
		
		//ApplicationContext ac=new AnnotationConfigApplicationContext(SpringAppConfigForSSM.class);
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontextforssm.xml");
		IDepartmentService ds=ac.getBean("DepartmentServiceWithSSM",IDepartmentService.class);
		
		try {
			DepartmentModel dm=ds.getByNoWithEmployees(1);
			System.out.println(dm.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
