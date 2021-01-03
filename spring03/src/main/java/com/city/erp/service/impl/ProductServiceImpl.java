package com.city.erp.service.impl;

import java.util.Date;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;


public class ProductServiceImpl implements IProductService {
	private SessionFactory sessionFactory=null;
	public ProductServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	//增加产品
	@Override
	public void add(ProductModel em) throws Exception {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.save(em);
		ts.commit();
		session.close();
	}
	
	//取得产品名称中包含key的产品列表
	@Override
	public List<ProductModel> getListBySearchName(String key) throws Exception {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		String hql="from ProductModel pm where pm.name like :key";
		Query<ProductModel> query=session.createQuery(hql,ProductModel.class);
		query.setParameter("key", "%"+key+"%");
		List<ProductModel> list=query.getResultList();
		ts.commit();
		session.close();
		return list;
	}

	@Override
	public List<ProductModel> getListByDateScope(Date start, Date end) throws Exception {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		String hql="from ProductModel pm where pm.date between :start and :end";
		Query<ProductModel> query=session.createQuery(hql,ProductModel.class);
		query.setParameter("start", start);
		query.setParameter("end", end);
		List<ProductModel> list=query.getResultList();
		ts.commit();
		session.close();
		return list;
	}
	
	//取得产品单价在low和high之间的产品列表
	@Override
	public List<ProductModel> getListByPriceScope(double low, double high) throws Exception {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		String hql="from ProductModel pm where pm.price between :low and :high";
		Query<ProductModel> query=session.createQuery(hql,ProductModel.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		List<ProductModel> list=query.getResultList();
		ts.commit();
		session.close();
		return list;
	}

	 //取得所有的产品的汇总金额
	@Override
	public double getTotalAmountByAll() throws Exception {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		String hql="select sum(pm.price*pm.qty) from ProductModel pm";
		Query<Double> query=session.createQuery(hql,Double.class);
		double result=query.getSingleResult();
		ts.commit();
		session.close();
		return result;
	}

	//取得日期在start和end之间的产品个数。
	@Override
	public int getCountByDateScope(Date start, Date end) throws Exception {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		String hql="select count(pm.no) from ProductModel pm where pm.date between :start and :end";
		Query<Long> query=session.createQuery(hql,Long.class);
		query.setParameter("start", start);
		query.setParameter("end", end);
		int result=query.getSingleResult().intValue();
		ts.commit();
		session.close();
		return result;
	}

}
