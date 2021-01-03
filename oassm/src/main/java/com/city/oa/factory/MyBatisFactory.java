package com.city.oa.factory;

import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.TypeAliasRegistry;

import com.city.oa.dao.IDepartmentDao;
import com.city.oa.model.DepartmentModel;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//创建SqlSessionFactory工厂

public class MyBatisFactory {

	private static SqlSessionFactory ssf=null;
	
	public static SqlSessionFactory createSqlSessionFactory() throws Exception{
		
		if(ssf==null) {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			ssf=new SqlSessionFactoryBuilder().build(inputStream);
			
		}
		return ssf;
		
	}

	public static SqlSessionFactory createSqlSessionFactory(String envId) throws Exception{
		
		if(ssf==null) {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			ssf=new SqlSessionFactoryBuilder().build(inputStream,envId);
			
		}
		return ssf;
		
	}
	
	public static SqlSessionFactory createSqlSessionFactory(Properties pros) throws Exception{
		
		if(ssf==null) {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			ssf=new SqlSessionFactoryBuilder().build(inputStream,pros);
			
		}
		return ssf;
		
	}

	//编程方式配置MyBatis
	public static SqlSessionFactory createSqlSessionFactoryNoXML() throws Exception{
		
		if(ssf==null) {
			
			//使用C3P0配置连接池
			ComboPooledDataSource cpds=new ComboPooledDataSource();
			cpds.setDriverClass("com.mysql.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3319/cityoa");
			cpds.setUser("cityoa");
			cpds.setPassword("cityoa");
			//2.设置连接池的参数
			cpds.setInitialPoolSize(1);
			cpds.setMaxPoolSize(2);
			
			//创建事务管理器
			TransactionFactory transactionFactory =new JdbcTransactionFactory();
			//创建环境,引入C3P0连接池，和事务管理器
			Environment environment = new Environment("development", transactionFactory, cpds);
			//创建配置类
			Configuration configuration = new Configuration(environment);
			//引入Mapper
			configuration.addMapper(IDepartmentDao.class);
			configuration.addMappers("com.city.oa.dao");  //引入DAO接口的包
			//注册别名
			configuration.getTypeAliasRegistry().registerAliases("com.city.oa.model");
			configuration.getTypeAliasRegistry().registerAliases("com.mybatis3.domain");
			
			//设置全局参数
			configuration.setCacheEnabled(true);
			configuration.setLazyLoadingEnabled(false);
			configuration.setMultipleResultSetsEnabled(true);
			configuration.setUseColumnLabel(true);
			
			
			ssf= new SqlSessionFactoryBuilder().build(configuration);
			
		}
		return ssf;
		
	}

	
}
