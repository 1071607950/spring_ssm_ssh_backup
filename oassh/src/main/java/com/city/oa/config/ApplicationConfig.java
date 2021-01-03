package com.city.oa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.city.oa.service.IBehaveService;
import com.city.oa.service.IDepartmentService;
import com.city.oa.service.impl.BehaveServiceImplWithHibernate;
import com.city.oa.service.impl.DepartmentServiceImplWithHibernate;

//实现Spring IoC容器的Bean配置的配置类
//@Configuration
//引入业务层的Bean的配置类
//@Import(value= {AppServiceConfig.class,AppDaoConfig.class})
public class ApplicationConfig {
	
}
