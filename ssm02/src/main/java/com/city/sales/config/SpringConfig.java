package com.city.sales.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.city.sales.factory.MyBatisFactory;
import com.city.sales.service.IOrderService;
import com.city.sales.service.impl.OrderServiceImpl;

@Configuration
@ComponentScan(basePackages= {"com.city.sales"})
public class SpringConfig {
	
	@Bean
	public SqlSessionFactory createSqlSessionFactory() throws Exception  {
		return MyBatisFactory.createSqlSessionFactory();
	}
	
	@Bean(name="OrderService")
	public IOrderService orderService(SqlSessionFactory sqlSessionFactory){
		return new OrderServiceImpl(sqlSessionFactory);
	}
}
