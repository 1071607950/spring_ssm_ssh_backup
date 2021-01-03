package com.city.oa.aop;



import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//测试Controller的AOP Advice
@Component
@Aspect
public class SpringMVCControllerAdvice {
	
	@Before(value="execution(* com.city.oa.controller.*.*(..))")
	public void methodBefore(JoinPoint jp) throws Exception{
		
		System.out.println("Controller的方法前 Advice测试。。。。");
	}

}
