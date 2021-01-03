package com.city.erp.service;

import java.util.Date;
import java.util.List;

import com.city.erp.model.ProductModel;

//产品的业务接口
public interface IProductService {
	public void add(ProductModel em) throws Exception; //增加产品
	public List<ProductModel> getListBySearchName(String key)  throws Exception; //取得产品名称中包含key的产品列表
	public List<ProductModel> getListByDateScope(Date start, Date end)  throws Exception; //参数， start起始日期， end：截止日期
	public List<ProductModel> getListByPriceScope(double low, double high)  throws Exception; //取得产品单价在low和high之间的产品列表
	public double getTotalAmountByAll() throws Exception; //取得所有的产品的汇总金额
	public int getCountByDateScope(Date start, Date end) throws Exception; //取得日期在start和end之间的产品个数。 
}
