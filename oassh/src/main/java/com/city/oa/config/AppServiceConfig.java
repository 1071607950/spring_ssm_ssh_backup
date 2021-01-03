package com.city.oa.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.service.IBehaveService;
import com.city.oa.service.IDepartmentService;
import com.city.oa.service.impl.BehaveServiceImplWithHibernate;
import com.city.oa.service.impl.DepartmentServiceImplWithDIAndHibernate;
import com.city.oa.service.impl.DepartmentServiceImplWithHibernate;


//OA项目Service层 Bean的配置类
//@Configuration
//@Import({AppDaoConfig.class})
public class AppServiceConfig {
	//配置通过调用构造方法取得Bean对象
	
	@Bean(name="departmentService",initMethod="init",destroyMethod="cleanup")
	@Scope("prototype")
	public IDepartmentService departmentService() {
		return new DepartmentServiceImplWithHibernate();
	}
	
	//配置通过调用工厂的静态方法取得Bean对象
	@Bean(name="departmentServiceFromStaticFactory")
	public IDepartmentService departmentServiceFromStaticFactory() {
		return ServiceFactory.createDepartmentService();
	}
	//配置通过调用工厂的动静态方法取得Bean对象
	//@Bean(name="departmentServiceFromDynamicFactory")
	public IDepartmentService departmentServiceFromDynamicFactory() {
		return new ServiceFactory().createDepartmentServiceDynamic();
	}
	
	
	
	
	//配置类方式实现依赖注入
	//@Bean(name="departmentServiceWithIoC")
	public IDepartmentService departmentServiceWithIoC(SessionFactory createSessionFactoryWithFactory) {
		//属性set注入
		DepartmentServiceImplWithDIAndHibernate ds=new DepartmentServiceImplWithDIAndHibernate();
		ds.setSessionFactory(createSessionFactoryWithFactory); //属性set注入方式
		return ds;
		
		//构造方法注入
		//return new DepartmentServiceImplWithDIAndHibernate(createSessionFactoryWithFactory);
	}

}
