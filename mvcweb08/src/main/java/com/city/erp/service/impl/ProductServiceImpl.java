package com.city.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.erp.dao.IProductDao;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductDao productDao=null;

	@Override
	public void add(ProductModel sm) throws Exception {
		productDao.insert(sm);
	}

	@Override
	public List<ProductModel> selectListByAll() throws Exception {
		return productDao.selectListByAll();
	}
	

}
