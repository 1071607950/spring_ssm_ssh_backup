package com.city.erp.service;

import java.util.List;

import com.city.erp.model.ProductModel;

public interface IProductService {
	public void add(ProductModel sm) throws Exception; //增加产品
	public List<ProductModel> selectListByAll() throws Exception;  //取得所有产品列表
}
