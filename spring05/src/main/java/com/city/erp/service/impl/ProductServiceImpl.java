package com.city.erp.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {
	@Autowired
	private SessionFactory sessionFactory=null;
	@Override
	public void add(ProductModel sm) throws Exception {
		sessionFactory.getCurrentSession().save(sm);
	}

	@Override
	public boolean checkProductExist(int no) throws Exception {
		return sessionFactory.getCurrentSession().get(ProductModel.class, no)!=null;
	}

	@Override
	public List<ProductModel> getListByPriceScope(double low, double high) throws Exception {
		return sessionFactory.getCurrentSession()
				.createQuery("select pm from ProductModel pm where price between :low and :high",ProductModel.class)
				.setParameter("low", low)
				.setParameter("high", high)
				.getResultList();
	}

	@Override
	public double getAvgPrice() {
		return sessionFactory.getCurrentSession()
				.createQuery("select avg(pm.price*pm.qty) from ProductModel pm",Double.class)
				.getSingleResult();
	}

	@Override
	public List<ProductModel> getListByCondition(String nameKey, double low, double high) throws Exception {
		StringBuilder hql=new StringBuilder("select pm from ProductModel pm where 1=1");
		if(nameKey!=null&&nameKey.trim().length()>0) {
			hql.append(" and pm.name like :name");
		}
		if(low!=0) {
			hql.append(" and pm.price>=:low");
		}
		if(high!=0) {
			hql.append(" and pm.price<=:high");
		}
		Query<ProductModel> query=sessionFactory.getCurrentSession().createQuery(hql.toString(),ProductModel.class);
		if(nameKey!=null&&nameKey.trim().length()>0) {
			query.setParameter("name", "%"+nameKey+"%");
		}
		if(low!=0) {
			query.setParameter("low", low);
		}
		if(high!=0) {
			query.setParameter("high", high);
		}
		return query.getResultList();
	}

	@Override
	public int getCountByCondition(String nameKey, double low, double high) throws Exception {
		StringBuilder hql=new StringBuilder("select count(pm.no) from ProductModel pm where 1=1");
		if(nameKey!=null&&nameKey.trim().length()>0) {
			hql.append(" and pm.name like :name");
		}
		if(low!=0) {
			hql.append(" and pm.price>=:low");
		}
		if(high!=0) {
			hql.append(" and pm.price<=:high");
		}
		Query<Long> query=sessionFactory.getCurrentSession().createQuery(hql.toString(),Long.class);
		if(nameKey!=null&&nameKey.trim().length()>0) {
			query.setParameter("name", "%"+nameKey+"%");
		}
		if(low!=0) {
			query.setParameter("low", low);
		}
		if(high!=0) {
			query.setParameter("high", high);
		}
		return query.getSingleResult().intValue();
	}
	

}
