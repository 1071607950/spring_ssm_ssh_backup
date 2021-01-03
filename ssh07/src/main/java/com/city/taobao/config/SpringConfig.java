package com.city.taobao.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//Spring集成Hibernate的配置类
@Configuration
@ComponentScan(basePackages= {"com.city.taobao"})
@EnableAspectJAutoProxy
@EnableTransactionManagement //启用Spring事务管理
public class SpringConfig {
	//配置数据库连接池
	//使用Spring内置的JDBC连接池框架
	//@Bean
	public DataSource dataSourceWithinSping() throws Exception{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/citytb?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		System.out.println("Spring内置连接池工作了...");
		return dataSource;
	}
	
	//使用c3p0连接池框架
	@Bean
	public DataSource dataSourceWithC3P0() throws Exception{
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/citytb?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false");
		cpds.setUser("root");
		cpds.setPassword("root");
		//设置连接池的参数
		cpds.setInitialPoolSize(1);
		cpds.setMaxPoolSize(2);
		System.out.println("配置类:C3P0 DataSource....");
		return cpds;
	}
	
	//使用Tomcat配置的连接池
	//@Bean
	public DataSource dataSource() throws Exception{
		return new JndiDataSourceLookup().getDataSource("java:comp/env/mysqlcitytb");
	}
	
	//配置Hibernate的属性
	public Properties hibernateProperties() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "false");
		return properties;
	}

	//配置Hibernate SessionFactory,并DI注入连接池对象DataSource
	//使用扫描注解Model类的方式
	@Bean
	public LocalSessionFactoryBean sessionfactory(DataSource dataSource){
		LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan("com.city.taobao.model");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		System.out.println("配置类:Hibernate SessionFactoryBean工作...");
		return sessionFactoryBean;
	}
	
	//配置Spring管理Hibernate的事务管理器
	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) throws Exception{
		HibernateTransactionManager tx=new HibernateTransactionManager();
		tx.setSessionFactory(sessionFactory);
		System.out.println("配置类:Hibernate事务管理器工作...");
		return tx;
	}
}
