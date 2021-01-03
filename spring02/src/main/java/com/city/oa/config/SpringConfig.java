package com.city.oa.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.city.oa.factory.HibernateFactory;
import com.city.oa.service.IEmployeeService;
import com.city.oa.service.impl.EmployeeServiceImpl;
@Configuration
@ComponentScan(basePackages= {"com.cty.oa"})

public class SpringConfig {
	
	@Bean
	public SessionFactory createSessionFactory() throws Exception {
		return HibernateFactory.createSessionFactory();
	}
	@Bean(name="employeeService")
	public IEmployeeService employeeService(SessionFactory sessionFactory) {
		EmployeeServiceImpl es=new EmployeeServiceImpl();
		es.setSessionFactory(sessionFactory);
		return es;
	}
}
