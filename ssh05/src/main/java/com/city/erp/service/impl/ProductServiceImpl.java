package com.city.erp.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.city.erp.factory.HibernateFactory;
import com.city.erp.model.AreaModel;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;
//部门的业务实现类
public class ProductServiceImpl implements IProductService {
	@Override
	public int add(ProductModel pm) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
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
		return pm.getNo();
	}

	@Override
	public void addArea(int productNo, int areaNo) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的产品对象
		ProductModel pm=session.get(ProductModel.class, productNo);
		//取得指定的区域对象
		AreaModel am=session.get(AreaModel.class, areaNo);
		//为产品增加区域对象
		pm.getAreas().add(am);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}

	@Override
	public void addAreas(int productNo, int[] areaNos) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的产品对象
		ProductModel pm=session.get(ProductModel.class, productNo);
		pm.getAreas().clear();
		for(int areaNo:areaNos) {
			//取得指定的区域对象
			AreaModel am=session.get(AreaModel.class, areaNo);
			//为产品增加区域对象
			pm.getAreas().add(am);//通过向产品的区域集合里增加区域对象,实现对关联表记录的增加
		}
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}
}
