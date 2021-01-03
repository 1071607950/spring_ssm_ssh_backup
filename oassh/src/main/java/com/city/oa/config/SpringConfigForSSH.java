package com.city.oa.config;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
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
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//Spring集成Hibernate的配置类

@Configuration
@ComponentScan(basePackages = { "com.city.oa"})
@EnableAspectJAutoProxy
@EnableTransactionManagement  //启用Spring事务管理
public class SpringConfigForSSH {
	
	//配置数据库连接池
	//使用Spring内置的JDBC连接池框架
	//@Bean
	public DataSource dataSourceWithinSpring() throws Exception{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3319/cityoa");
		dataSource.setUsername("cityoa");
		dataSource.setPassword("cityoa");
		System.out.println("Spring内置连接池工作了。。。。。");
		return dataSource;
		
	}
	
	//使用C3P0连接池框架
	@Bean
	public DataSource dataSourceWithC3P0() throws Exception{
		
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3319/cityoa");
		cpds.setUser("cityoa");
		cpds.setPassword("cityoa");
		//2.设置连接池的参数
		cpds.setInitialPoolSize(1);
		cpds.setMaxPoolSize(2);
		System.out.println("配置类：C3P0 DataSource。。。。");
		return cpds;
		
	}
	// 使用Tomcat配置的连接池
	//使用Spring提供的JndiDataSourceLookup在命名空间内查找
	//@Bean
	public DataSource dataSourceWithTomcatAndSpring() throws Exception{
		return new JndiDataSourceLookup().getDataSource("java:comp/env/cityoa");
	}
	
	// 使用Tomcat配置的连接池
	//使用JNDI API在命名空间内查找
	//@Bean
	public DataSource dataSourceWithTomcatAndJNDI() throws Exception{
		Context ctx=new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/cityoa");
		ctx.close();
		return ds;
	}
	
	//配置Hibernate的属性
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql",true);
		return properties;
	}
	
	//配置Hibernate SessionFactory， 并DI注入连接池对象DataSource
	//使用扫描注解Model类的方式
	@Bean
	public LocalSessionFactoryBean sessionfactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan("com.city.oa.model");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		System.out.println("配置类：Hibernate SessionFactoryBean工作。。。。");
		return sessionFactoryBean;
	}
	//配置Spring管理Hibernate的事务管理器
	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) throws Exception {
				
			HibernateTransactionManager tx=new HibernateTransactionManager();
			tx.setSessionFactory(sessionFactory);
			System.out.println("配置类：Hibernate事务管理器工作。。。。");
			return tx;
	}

}
