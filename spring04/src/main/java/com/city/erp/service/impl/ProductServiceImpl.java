package com.city.erp.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;

@Service("productService")
public class ProductServiceImpl implements IProductService {
	
	private Session session=null;
	
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void add(ProductModel pm) throws Exception {
		session.save(pm);
//		throw new Exception("这是一个自定义异常");
	}
	@Override
	public List<ProductModel> getListByAll() throws Exception {
		return session.createQuery("from ProductModel pm",ProductModel.class).getResultList();
		
	}

}
