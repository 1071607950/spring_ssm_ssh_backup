package com.city.erp.service;

import java.util.List;

import com.city.erp.model.ProductModel;

public interface IProductService {
	public void add(ProductModel sm) throws Exception; //增加产品
	public ProductModel getByNo(int productNo) throws Exception; //取得指定产品
	public List<ProductModel> getListByAllWithPage(int rows,int page) throws Exception; //取得所有的产品列表, 分页模式
	public int getCountByAll() throws Exception; //取得所有产品个数
	public int getPageCount(int rows) throws Exception;
	public double getTotalAmountByAll() throws Exception; //取得所有产品的累计金额
}
