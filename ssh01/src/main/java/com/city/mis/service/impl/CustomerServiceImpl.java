package com.city.mis.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.city.mis.factory.HibernateFactory;
import com.city.mis.model.CustomerModel;
import com.city.mis.service.ICustomerService;
//部门的业务实现类
public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void add(CustomerModel cm) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.save(cm);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}
	public void modify(CustomerModel cm) throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.update(cm);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}

}
