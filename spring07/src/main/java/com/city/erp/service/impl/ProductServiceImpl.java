package com.city.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.erp.dao.IProductDao;
import com.city.erp.model.AreaModel;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductDao productDao=null;
	@Override
	public void add(ProductModel pm) throws Exception {
		productDao.insert(pm);
	}

	@Override
	public void addAreas(int pno, int[] areas) throws Exception {
		productDao.insertAreas(pno, areas);
	}

	@Override
	public List<AreaModel> getAreaListByProduct(int productNo) throws Exception {
		return productDao.selectAreaListByProduct(productNo);
	}

	@Override
	public List<ProductModel> getProductListWithoutArea() throws Exception {
		return productDao.selectProductListWithoutArea();
	}

}
