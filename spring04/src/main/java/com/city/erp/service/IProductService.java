package com.city.erp.service;

import java.util.List;

import com.city.erp.model.ProductModel;

//产品的业务接口
public interface IProductService {
	public void add(ProductModel pm) throws Exception; //增加产品
	public List<ProductModel> getListByAll() throws Exception;
}
