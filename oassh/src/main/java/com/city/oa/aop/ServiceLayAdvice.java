package com.city.oa.aop;

import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.city.oa.model.DepartmentModel;

//业务Service的AOP Advice类
//@Component
//@Aspect
//@Order(value=1)
public class ServiceLayAdvice {
	//引入切入点类的指定方法的切入点
	//@Before( value="com.city.oa.aop.ServiceAOPPointcut.serviceImplPointcut()")
	//@Before(value="execution(* com.city.oa.service.impl.*.*(..))")
	@Before(value="com.city.oa.aop.ServiceAOPPointcut.annotationServicepointcut()")
	public void methodBeforeRun(JoinPoint jp) throws Exception{
		System.out.println("业务层方法前切面代码执行,信息:"+jp.toString());
		
		
	}
	//方法返回后Advice方法
	@AfterReturning(value="com.city.oa.aop.ServiceAOPPointcut.annotationServicepointcut()", returning="result")
	public void methodAfterReturing(Object result) throws Exception{
		System.out.println("业务层方法返回后切面代码执行。。。。");
		if(result instanceof List<?>) {
			System.out.println("返回集合个数："+((List)result).size());
		}
		else if(result instanceof DepartmentModel) {
			System.out.println("返回部门名称："+ ((DepartmentModel)result).getName());
		}
	}
	
	//方法抛出异常后Advice
	@AfterThrowing(value="com.city.oa.aop.ServiceAOPPointcut.annotationServicepointcut()",throwing="ex")
	public void methodAfterThrowException(Exception ex) throws Exception{
		System.out.println("业务层方法出现异常后切面代码执行。。。。");
		System.out.println("异常的原因："+ex.getMessage());
		
		
	}
	
	//环绕Advice
	@Around(value="com.city.oa.aop.ServiceAOPPointcut.annotationServicepointcut()")
	public Object serviceMethodRunTimeAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("业务层方法前切面代码执行。。。。");
		Date starttime=new Date();
		Object result=pjp.proceed();
		Date endtime=new Date();
		System.out.println("业务层方法后切面代码执行。。。。");
		
		System.out.println("业务层方法执行时间:"+(endtime.getTime()-starttime.getTime())+"毫秒");
		
		return result;
	}
}
