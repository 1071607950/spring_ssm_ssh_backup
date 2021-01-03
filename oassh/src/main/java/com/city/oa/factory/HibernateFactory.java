package com.city.oa.factory;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.city.oa.model.DepartmentModel;

public class HibernateFactory {
	private static SessionFactory sf=null;
	//XML方式配置Hibernate
	public static SessionFactory createSessionFactory() throws Exception{
		if(sf==null) {
			Configuration cfg=new Configuration();
			cfg.configure();
			//读取hibernate.cfg.xml配置文件
			//cfg.configure("config/lhd.cfg.xml");
			//cfg.addClass(DepartmentModel.class);
			//cfg.addResource("com/city/oa/model/DepartmentModel.hbm.xml")
			//
			//cfg.addPackage("com.city.oa.moodel");
			//cfg.addResource("com/city/oa/model/DepartmentModel.hbm.xml");
			
			//创建SessionFactory对象
			sf=cfg.buildSessionFactory();
		}
		return sf;
	}
	//编程方式配置Hibernate
	public static SessionFactory createSessionFactoryFromProgramming() throws Exception{
		if(sf==null) {
			Configuration cfg=new Configuration();
			//设置单个属性
			cfg.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
			cfg.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3319/cityoa");
			cfg.setProperty("hibernate.connection.username","cityoa");
			cfg.setProperty("hibernate.connection.password","cityoa");
			cfg.setProperty("hibernate.show_sql", "true");
			cfg.setProperty("hibernate.format_sql", "true");
			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			//通过Properties集合设置多个属性
			//Properties p=new Properties();
			//p.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			//cfg.setProperties(p);
			//指定映射的注解Model类
			//cfg.addAnnotatedClass(DepartmentModel.class);
			cfg.addPackage("com.city.oa.moodel");
			cfg.addResource("com/city/oa/model/DepartmentModel.hbm.xml");
			cfg.addClass(DepartmentModel.class);
			//创建SessionFactory对象
			sf=cfg.buildSessionFactory();
		}
		return sf;
	}
	
	

}
