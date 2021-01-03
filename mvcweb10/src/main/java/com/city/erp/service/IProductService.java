package com.city.erp.service;

import java.util.List;

import com.city.erp.model.ProductModel;

public interface IProductService {
	public void add(ProductModel sm) throws Exception; //增加产品
	public ProductModel getById(int no) throws Exception;
	public ProductModel getByIdWithPhoto(int no) throws Exception;
	public List<ProductModel> getListByPriceWithPage(double low,double high, int page, int rows) throws Exception;  //取得单价在low和high之间的分页方式的产品列表。page:第几页，rows：每页显示的个数
	public int getCountByPrice(double low,double high) throws Exception; //取得价格在low和high之间的产品的个数
	public int getPageCountByPrice(double low,double high,int rows) throws Exception; //取得价格在low和high之间的产品的页数。
}
