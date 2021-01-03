package com.city.oa.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.city.oa.factory.HibernateFactory;

//持久层DAO Bean对象的配置
//@Configuration
public class AppDaoConfig {

	//配置SessionFactory
	@Bean
	public SessionFactory createSessionFactory() throws Exception{
		org.hibernate.cfg.Configuration cfg=new org.hibernate.cfg.Configuration();
		cfg.configure();
		System.out.println("sessionfactory01工作。。。。");
		return cfg.buildSessionFactory();
	}
	
	//@Bean
	public SessionFactory createSessionFactoryWithFactory() throws Exception{
		System.out.println("sessionfactory02工作。。。。");
		return HibernateFactory.createSessionFactory();
	}
	
		
}
