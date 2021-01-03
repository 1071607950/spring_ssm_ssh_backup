package com.city.erp.service;

import com.city.erp.model.ProductModel;

public interface IProductService {
	public void add(int categoryNo,String name,double price,int qty) throws Exception;//增加产品
	public void modify(int no,String name,int categoryNo,double price,int qty) throws Exception;//修改产品
	public void changePrice(int productNo, double price) throws Exception; //修改产品的单价
	public double getPriceByProduct(int productNo) throws Exception; //取得指定产品的单价 
	public void delete(int no) throws Exception; //删除产品
	public ProductModel getProduct(int no) throws Exception; //取得指定编号的产品信息
	public double getAmontByProduct(int productNo) throws Exception;  //取得指定产品的金额。 单价x 数量=金额
	public int getTotalQTYByCategory(int categoryNo) throws Exception; //取得指定类别的产品金额汇总
	public boolean checkProductInCategory(int productNo, int categoryNo) throws Exception; //检查指定的产品是否在指定的产品类别中。
}
