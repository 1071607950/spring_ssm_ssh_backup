package com.city.oa.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.city.oa.service.impl.DepartmentServiceImplWithAOPAndHibernate;

//@Component
//@Aspect
public class BusinessServiceTransactionAdvice {
	@Autowired
	private SessionFactory sessionFactory=null;
	
	@Around(value="com.city.oa.aop.ProjectAOPPointcut.businessServiceWithAOPAndHibernate()")
	public Object serviceMethodHibernateTransaction(ProceedingJoinPoint pjp) throws Throwable{
		
		System.out.println("Hibernate事务处理Advice 方法前执行。。。。。");
		
		Session session=sessionFactory.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		if(pjp.getTarget() instanceof DepartmentServiceImplWithAOPAndHibernate) {
			((DepartmentServiceImplWithAOPAndHibernate)pjp.getTarget()).setSession(session);
		}
		
		Object result=pjp.proceed();
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		
		System.out.println("Hibernate事务处理Advice 方法后执行。。。。。");
		return result;
	}
	

}
