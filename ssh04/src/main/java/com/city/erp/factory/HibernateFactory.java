package com.city.erp.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
	private static SessionFactory sf=null;
	//XML方式配置hibernate
	public static SessionFactory getSessionFactory() throws Exception{
		if(sf==null) {
			Configuration cfg=new Configuration();
			//读取hibernate.cfg.xml配置文件
			cfg.configure();
			//cfg.addClass(DepartmentModel.class);
			//创建SessionFactory对象
			sf=cfg.buildSessionFactory();
		}
		return sf;
	}
}
