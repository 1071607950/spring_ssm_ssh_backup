package com.city.erp.factory;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//创建SqlSessionFactory工厂

public class MyBatisFactory {
	private static SqlSessionFactory ssf=null;
	
	public static SqlSessionFactory createSqlSessionFactory() throws Exception{
		if(ssf==null) {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			ssf = new SqlSessionFactoryBuilder().build(inputStream);
		}
		return ssf;
	}

}
