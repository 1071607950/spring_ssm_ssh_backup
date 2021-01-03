package com.city.erp.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.city.erp.service.impl.ProductServiceImpl;

@Component
@Aspect
public class ServiceMainAdvice {
	
	@Autowired
	private SessionFactory sessionFactory=null;
	
	@Around(value = "execution(* com.city.erp.service.impl.*.*(..))")
	public Object serviceMethodRunTime(ProceedingJoinPoint pjp) throws Throwable{
		Date start=new Date();
		//方法前代码区
		Object result=pjp.proceed();//目标对象方法
		//方法后代码区
		Date end=new Date();
		System.out.println("类:"+pjp.getTarget().getClass().getName()+",方法:"+pjp.getSignature().getName()+",执行时间是:"+(end.getTime()-start.getTime())+"毫秒");
		return result;
	}
	@Around(value = "execution(* com.city.erp.service.impl.*.*(..))")
	public Object transactionMethod(ProceedingJoinPoint pjp) throws Throwable{
		//创建Session
		Session session=sessionFactory.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		if(pjp.getTarget() instanceof ProductServiceImpl) {
			((ProductServiceImpl)pjp.getTarget()).setSession(session);
		}
		Object result=pjp.proceed();
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
		return result;
	}

	//异常抛出后切面
	@AfterThrowing(value = "execution(* com.city.erp.service.impl.*.*(..))",throwing="ex")
	public void exceptionHanding(JoinPoint jp,Exception ex) throws Exception{
		String date=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
		System.out.println("类:"+jp.getTarget().getClass().getName()+",方法:"+jp.getSignature().getName()+"时间:"+date+"异常:"+ex.getMessage());
	}
}
