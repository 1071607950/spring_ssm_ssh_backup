package com.city.oaapp.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.city.oaapp.factory.HibernateFactory;
import com.city.oaapp.model.EmployeeModel;
import com.city.oaapp.service.IEmployeeService;
//部门的业务实现类
public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public void add(EmployeeModel em) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.save(em);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}

}
