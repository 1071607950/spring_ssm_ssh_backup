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
	public List<ProductModel> getListByPriceWithPage(double low, double high, int page, int rows) throws Exception {
		return productDao.selectListByPriceWithPage(low, high, rows*(page-1), rows);
	}

	@Override
	public int getCountByPrice(double low, double high) throws Exception {
		return productDao.selectCountByPrice(low, high);
	}

	@Override
	public int getPageCountByPrice(double low, double high, int rows) throws Exception {
		int count=productDao.selectCountByPrice(low, high);
		if(count%rows==0) {
			return count/rows;
		}else {
			return count/rows+1;
		}
	}


	

}
