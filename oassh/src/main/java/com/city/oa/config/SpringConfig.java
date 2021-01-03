package com.city.oa.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.service.IBehaveService;
import com.city.oa.service.IDepartmentService;
import com.city.oa.service.impl.BehaveServiceImplWithHibernate;
import com.city.oa.service.impl.DepartmentServiceImplWithDIAndHibernate;
import com.city.oa.service.impl.DepartmentServiceImplWithHibernate;


//Spring的Java配置类
//@Configuration
//@ComponentScan(basePackages = { "com.city.oa"})
public class SpringConfig {
	
	
	/*
	@Bean
	
	@Scope("prototype")
	public IDepartmentService departmentService() {
		return new DepartmentServiceImplWithHibernate();
	}
	*/
	/*
	@Bean
	@Scope("singleton")
	public IDepartmentService departmentService() {
		return new DepartmentServiceImplWithHibernate();
	}
	@Bean
	public IBehaveService behaveService() {
		return new BehaveServiceImplWithHibernate();
	}
	*/
	
	//配置SessionFactory 的Bean
	@Bean
	public SessionFactory createSessionFactory() throws Exception{
		org.hibernate.cfg.Configuration cfg=new org.hibernate.cfg.Configuration();
		cfg.configure();
		
		return cfg.buildSessionFactory();
	}
	//配置业务层对象Bean， 并传入SessionFactory Bean，作为部门实现类的构造方法参数
	//@Bean(name="departmentService")
	/*
	public IDepartmentService createDepartmentService(SessionFactory createSessionFactory01) throws Exception{
		return new DepartmentServiceImplWithHibernateAndIoC(createSessionFactory01);
	}
	@Bean(name="departmentService")
	public IDepartmentService createDepartmentService() throws Exception{
		return new DepartmentServiceImplWithHibernateAndIoC(createSessionFactory());
	}
	*/
	@Bean(name="departmentService")
	public IDepartmentService createDepartmentService() throws Exception{
		DepartmentServiceImplWithDIAndHibernate ds=new DepartmentServiceImplWithDIAndHibernate();
		ds.setSessionFactory(createSessionFactory());
		return ds;
	}
	
	
}
