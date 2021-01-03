package com.city.erp.config;

import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.city.erp.factory.HibernateFactory;
import com.city.erp.service.IProductService;
import com.city.erp.service.impl.ProductServiceImpl;
@Configuration
public class SpringConfig {
	
	@Bean
	public SessionFactory createSessionFactory() throws Exception {
		return HibernateFactory.createSessionFactory();
	}
	
	@Bean(name="productService")
	public IProductService productService(SessionFactory sessionFactory) {
		return new ProductServiceImpl(sessionFactory);
	}
	
}
