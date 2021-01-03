package com.city.erp.service;

import java.util.List;

import com.city.erp.model.ProductModel;

//产品的业务接口
public interface IProductService {
	public void add(ProductModel sm) throws Exception; //增加产品
	public boolean checkProductExist(int no) throws Exception;  //检查指定的产品号是否存在
	public List<ProductModel> getListByPriceScope(double low,double high) throws Exception; //取得单价在low和high之间的产品列表
	public double getAvgPrice(); //取得所有产品的加权平均单价
	public List<ProductModel> getListByCondition(String nameKey, double low,double high) throws Exception; //按检索条件取得产品列表。 条件动态生成。String类型的参数如果为空，则不包括此条件；int类型的参数为0则不包括此条件。
	public int getCountByCondition(String nameKey, double low,double high) throws Exception; //按检索条件取得产品个数。 条件动态生成。String类型的参数如果为空，则不包括此条件；int类型的参数为0则不包括此条件 
}
