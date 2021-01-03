package com.city.erp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.city.erp.service.IProductService;
import com.city.erp.service.impl.ProductServiceImpl;

@Configuration
public class AppConfig {
	@Bean(name="productService")
	public IProductService productService() {
		return new ProductServiceImpl();
	}

}
