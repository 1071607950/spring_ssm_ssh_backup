package com.city.oa.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.city.oa.model.DepartmentModel;

@Component("businessServiceAdvice")
@Aspect
public class BusinessServiceAdvice {
	
	@Before(value="com.city.oa.aop.ProjectAOPPointcut.businessServiceAllMethodPointcut()")
	public void methodBefore(JoinPoint jp) throws Exception{
		System.out.println("业务层方法前（before）切面代码执行。。。。。");
		System.out.println("切入类："+jp.getTarget().getClass().getName()+" 方法:"+jp.getSignature().getName());
		
		
	}
	
	@AfterReturning(value="com.city.oa.aop.ProjectAOPPointcut.businessServiceAllMethodPointcut()",returning="result")
	public void methodAfterReturing(JoinPoint jp,Object result) throws Exception{
		System.out.println("业务层方法返回后（after returing）切面代码执行。。。。。");
		if(result instanceof DepartmentModel) {
			System.out.println("切入方法返回部门对象，部门名称是："+ ((DepartmentModel)result).getName() );
		}
	}
	
	//@After(value="com.city.oa.aop.ProjectAOPPointcut.businessServiceAllMethodPointcut()")
	public void methodAfter(JoinPoint jp) throws Exception{
		System.out.println("业务层方法后（after）切面代码执行。。。。。");
	}
	
	//@Around("com.city.oa.aop.ProjectAOPPointcut.businessServiceAllMethodPointcut()")
	public Object methodAround(ProceedingJoinPoint pjp) throws Throwable {
		
		Date start=new Date();
		//方法前代码区
		System.out.println("业务层方法环绕（Around）方法前（before)代码执行。。。。。");
		
		Object result=pjp.proceed();  //目标对象方法
		//方法后代码区
		System.out.println("业务层方法环绕（Around）方法前（after)代码执行。。。。。");
		Date end=new Date();
		System.out.println("切入类："+pjp.getTarget().getClass().getName()+" 方法:"+pjp.getSignature().getName()+"的执行时间是："+(end.getTime()-start.getTime())+"毫秒" );
		
		return result;
		
	}
	//异常抛出后切面
	
	//@AfterThrowing(value="com.city.oa.aop.ProjectAOPPointcut.businessServiceAllMethodPointcut()",throwing="ex")
	public void afterThrowException(JoinPoint jp,Exception ex) throws Exception{
		System.out.println("业务层方法异常抛出后（After Exception throwing）切面代码执行。异常原因:"+ex.getMessage());
		
	}
	
	

}
