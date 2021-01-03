package com.city.erp.service.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.city.erp.factory.HibernateFactory;
import com.city.erp.model.AreaModel;
import com.city.erp.service.IAreaService;
//部门的业务实现类
public class AreaServiceImpl implements IAreaService {
	@Override
	public List<AreaModel> getListByAll() throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		Query<AreaModel> query=session.createQuery("from AreaModel",AreaModel.class);
		List<AreaModel> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
		return list;
	}
}
