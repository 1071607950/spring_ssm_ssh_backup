package com.city.erp.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.city.erp.factory.HibernateFactory;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;
//部门的业务实现类
public class ProductServiceImpl implements IProductService {
	@Override
	public void add(ProductModel pm) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.getSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.save(pm);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}
}
