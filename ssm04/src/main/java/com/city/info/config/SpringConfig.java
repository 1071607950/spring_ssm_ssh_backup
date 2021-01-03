package com.city.info.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//用于Spring集成MyBatis的配置类

@Configuration
//配置扫描Bean的起始路径
@ComponentScan(basePackages= {"com.city.info"})
//配置扫描MyBatis的DAO接口包
@MapperScan("com.city.info.dao")
//启用事务切面(Advice)
@EnableTransactionManagement
//启用AspectJ AOP注解
@EnableAspectJAutoProxy
public class SpringConfig {
	//==============================配置数据源==============================

	
	//使用C3P0连接池框架
	@Bean("dataSourceOfC3P0")
	public DataSource dataSourceWithC3P0() throws Exception{
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/cityinfo?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false");
		cpds.setUser("root");
		cpds.setPassword("root");
		//设置连接池的参数
		cpds.setInitialPoolSize(1);
		cpds.setMaxPoolSize(2);
		System.out.println("配置类:C3P0 DataSource....");
		return cpds;
	}
	
	//==============================配置MyBatis的SqlSessionFactory工厂bean==============================
	@Bean("sqlSessionFactory")
	public SqlSessionFactory createSqlSessionFactory(DataSource ds) throws Exception{
		SqlSessionFactoryBean ssfb=new SqlSessionFactoryBean();
		ssfb.setDataSource(ds);//设置连接池
		//配置XML文件的位置
		ResourcePatternResolver resourcePatternResolver=new PathMatchingResourcePatternResolver();
		ssfb.setMapperLocations(resourcePatternResolver.getResources("classpath:com/city/info/dao/xml/*.xml"));
		
		//读取Mybatis配置文件
		Resource resource=new ClassPathResource("mybatis-config.xml");
		ssfb.setConfigLocation(resource);
		
		//配置Model类的别名扫描包
		ssfb.setTypeAliasesPackage("com.city.info.model");
		return ssfb.getObject();
	}
	
	//==============================配置事务管理器==============================
	//使用Spring提供了JDBC DataSource事务管理器
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
