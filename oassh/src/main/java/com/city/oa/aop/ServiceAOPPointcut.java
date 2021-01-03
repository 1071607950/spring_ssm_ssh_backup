package com.city.oa.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//业务层的AOP的切入点定义类

@Component
@Aspect
public class ServiceAOPPointcut {
	
	@Pointcut("execution(* com.city.oa.service.impl.*.*(..))")
	public void serviceImplPointcut() {}
	
	@Pointcut("this(com.city.oa.service.IDepartmentService)")
	public void departmentServicepointcut() {}
	
	@Pointcut("@within(org.springframework.stereotype.Service)")
	public void annotationServicepointcut() {}
	
}
