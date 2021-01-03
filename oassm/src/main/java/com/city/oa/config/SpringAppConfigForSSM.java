package com.city.oa.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.city.oa.dao.IDepartmentDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
//配置扫描Bean的起始路径
@ComponentScan(basePackages= {"com.city.oa"})
//配置扫描MyBatis的DAO接口包
@MapperScan("com.city.oa.dao")
//启用使用切面（Advice）
@EnableTransactionManagement 
//启用AspectJ AOP注解
@EnableAspectJAutoProxy
public class SpringAppConfigForSSM {
	
	//=========================配置数据源========================
	//使用MyBatis提供的连接池
	//@Bean("myBatisDataSource")
	public DataSource createPooledDataSource() throws Exception{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/cityoa";
		String username = "root";
		String password = "root";
		PooledDataSource dataSource = new PooledDataSource(driver, url,	username, password);
		System.out.println("配置类：MyBatis内置DataSource。。。。");
		return dataSource;
	}
	//使用C3P0连接池框架
	@Bean(name="dataSourceOfC3P0")
	public DataSource dataSourceWithC3P0() throws Exception{
			ComboPooledDataSource cpds=new ComboPooledDataSource();
			cpds.setDriverClass("com.mysql.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/cityoa");
			cpds.setUser("root");
			cpds.setPassword("root");
			//2.设置连接池的参数
			cpds.setInitialPoolSize(1);
			cpds.setMaxPoolSize(2);
			System.out.println("配置类：C3P0 DataSource。。。。");
			return cpds;
	}
	//使用Tomcat配置的连接池，使用Spring提供的JNDI查询Bean
	//@Bean
	public DataSource dataSourceWithTomcatAndSpring() throws Exception{
		return new JndiDataSourceLookup().getDataSource("java:comp/env/cityoa");
	}
	
	//使用Tomcat配置的连接池，使用JNDI API查询Bean
	//@Bean
	public DataSource dataSourceWithTomcatAndJNDI() throws Exception{
		Context ctx=new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/cityoa");
		ctx.close();
		return ds;
	}
	
	//=========================配置MyBatis的SqlSessionFactory工厂bean=======================================
	@Bean("sqlSessionFactory")
	public SqlSessionFactory createSqlSessionFactory(DataSource ds) throws Exception{
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(ds); //设置连接池
		//配置XML映射文件的位置
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		ssfb.setMapperLocations(resourcePatternResolver.getResources("classpath:com/city/oa/dao/xml/*.xml"));
		
		//读取MyBatis配置文件
		Resource resource= new ClassPathResource("mybatis-configforssm.xml");
		ssfb.setConfigLocation(resource);
		
		//配置Model类的别名扫描包
		ssfb.setTypeAliasesPackage("com.city.oa.model");
		return ssfb.getObject();
	}
	//================ 配置事务管理器=====================================
	//使用Spring提供了JDBC DataSource事务管理器
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		  return new DataSourceTransactionManager(dataSource);
	}
	
	//=================DAO接口Bean的配置=================
	//方式1： 使用SqlSessionTemplate取得Dao接口，配置代码麻烦，不推荐使用
	//@Bean
	public IDepartmentDao createDepartmentDaoWithTemplate(SqlSessionFactory ssf) throws Exception{
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(ssf);
		System.out.println("使用SqlSessionTemplate创建DAO接口。。。。");
		return sqlSessionTemplate.getMapper(IDepartmentDao.class);			  
	}
	
	//方式2：使用MapperFactoryBean，每次只能配置一个DAO接口Bean对象，不推荐使用
	//@Bean
	public IDepartmentDao createDepartmentDaoWithMapperFactory(SqlSessionFactory ssf) throws Exception {
		MapperFactoryBean<IDepartmentDao> mfb=new MapperFactoryBean<IDepartmentDao>();
		mfb.setSqlSessionFactory(ssf);
		mfb.setMapperInterface(IDepartmentDao.class);
		System.out.println("使用MapperFactoryBean创建DAO接口。。。。");
		return mfb.getObject();
	}
	
	//方式3：使用MapperScannerConfigurer实现DAO接口的扫描方式配置DAO接口，老版本使用，新版本不推荐使用
	//@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(SqlSessionFactory ssf) throws Exception{
		MapperScannerConfigurer msc=new MapperScannerConfigurer();
		msc.setBasePackage("com.city.oa.dao"); //设置DAO接口扫描的起始包
		msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
		System.out.println("使用MapperScannerConfigurer 扫描DAO接口。。。。");
		return msc;
	}
	
	//方式4：MyBatis-Spring框架新版本提供的方法， 
	//在配置类前加入@MapperScan("org.mybatis.spring.sample.mapper")
	
	
	
	
	
	
	
	
	
	
	

}
