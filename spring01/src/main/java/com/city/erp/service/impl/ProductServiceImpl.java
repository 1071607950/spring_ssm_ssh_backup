package com.city.erp.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.city.erp.factory.HibernateFactory;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;

public class ProductServiceImpl implements IProductService {
	
	@Override
	public void add(String productId, String name, String model, double price) throws Exception {
		ProductModel pm=new ProductModel();
		pm.setId(productId);
		pm.setName(name);
		pm.setModel(model);
		pm.setPrice(price);
		SessionFactory sf= HibernateFactory.createSessionFactory();
		Session session=sf.openSession();
		Transaction ts=session.beginTransaction();
		session.save(pm);
		ts.commit();
		session.close();
	}

}
