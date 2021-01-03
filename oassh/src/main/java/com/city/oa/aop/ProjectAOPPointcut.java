package com.city.oa.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//项目的切入点集中定义的类
@Component
@Aspect
public class ProjectAOPPointcut {
	//业务层所有方法切入点
	@Pointcut(value="execution(* com.city.oa.service.impl.*.*(..))")
	public void businessServiceAllMethodPointcut() {}
	
	//业务层所有查询方法切入点
	@Pointcut(value="execution(* com.city.oa.service.impl.*.get*(..))")
	public void businessServiceRetriveMethodPointcut() {}
	
	@Pointcut(value="@target(org.springframework.transaction.annotation.Transactional)")
	public void businessserviceTransactionBean() {}
	
	@Pointcut(value="@annotation(org.springframework.transaction.annotation.Transactional)")
	public void businessserviceTransactionMethod() {}
	
	@Pointcut(value="execution(* com.city.oa.service.impl.*WithAOPAndHibernate.*(..))")
	public void businessServiceWithAOPAndHibernate() {}
	
	
	

}
