package com.city.sales.service;

import java.util.Date;
import java.util.List;

import com.city.sales.model.OrderModel;

//订单的业务接口
public interface IOrderService {
	public void add(OrderModel em) throws Exception;
	public List<OrderModel> getListBySearchName(String keyword)  throws Exception; //取得订单产品名称中包含keyword的订单列表
	public double getAmountByDateScope(Date start, Date end)  throws Exception; //参数， start起始日期， end：截止日期, 返回时间区间内的产品的累计金额。
	public List<OrderModel> getListByPriceScope(double low, double high)  throws Exception; //取得订单单价在low和high之间的订单列表
	public double getCountByPriceScope(double low,double hight) throws Exception; //取得价格在low和high之间所有的订单的个数。
	public double getAmountByProduct(String productName) throws Exception; //取得指定产品的订单累计金额。 每个订单的金额=单价*数量
	
}
