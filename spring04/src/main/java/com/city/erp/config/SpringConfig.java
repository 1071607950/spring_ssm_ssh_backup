package com.city.erp.config;

import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.city.erp.factory.HibernateFactory;
@Configuration
@ComponentScan(basePackages= {"com.city.erp"})
@EnableAspectJAutoProxy
public class SpringConfig {
	
	@Bean
	public SessionFactory createSessionFactory() throws Exception {
		return HibernateFactory.createSessionFactory();
	}
	
	
}
