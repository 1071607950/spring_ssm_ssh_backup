package com.city.taobao.service;

import java.util.Date;
import java.util.List;

import com.city.taobao.model.OrderModel;

public interface IOrderService {
	public List<OrderModel> getListByPriceScope(double min,double max) throws Exception; //取得产品单价在min和max之间的订单列表方法
	public List<OrderModel> getListByPriceWithPage(double low,double high,int rows, int page) throws Exception; //取得单价在low,high之间，每行rows记录；第page页的订单列表
	public int getCountByPrice(double low,double high) throws Exception; //取得单价在low和high的订单个数。
	public int getPageCountByPrice(double low,double high,int rows) throws Exception; //取得指定订单价格区间的总页数
	public List<OrderModel> getListBySearchCustomerName(String key) throws Exception; //取得客户名称中包含key的订单列表。
	public double getTotalAmountByDate(Date start,Date end) throws Exception; //取得订单日期在start和end之间的订单的累计订单金额 ， 金额=产品单价*产品数量。
}
