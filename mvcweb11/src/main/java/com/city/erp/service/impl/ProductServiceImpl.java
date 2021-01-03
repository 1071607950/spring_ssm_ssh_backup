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
	public ProductModel getByNo(int productNo) throws Exception {
		return productDao.selectByNo(productNo);
	}

	@Override
	public List<ProductModel> getListByAllWithPage(int rows, int page) throws Exception {
		return productDao.selectListByAllWithPage(rows, rows*(page-1));
	}

	@Override
	public int getCountByAll() throws Exception {
		return productDao.selectCountByAll();
	}
	
	@Override
	public int getPageCount(int rows) throws Exception {
		int count=productDao.selectCountByAll();
		if(count%rows==0) {
			return count/rows;
		}else {
			return count/rows+1;
		}
	}

	@Override
	public double getTotalAmountByAll() throws Exception {
		return productDao.selectTotalAmountByAll();
	}

}
