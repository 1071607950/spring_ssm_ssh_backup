package com.city.sales.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city.sales.model.OrderModel;

//订单的DAO接口
@Mapper
public interface IOrderDao {
	public void insert(OrderModel em) throws Exception;
	public List<OrderModel> selectListBySearchName(String keyword)  throws Exception; //取得订单产品名称中包含keyword的订单列表
	public double selectAmountByDateScope(@Param("start") Date start,@Param("end") Date end)  throws Exception; //参数， start起始日期， end：截止日期, 返回时间区间内的产品的累计金额。
	public List<OrderModel> selectListByPriceScope(@Param("low") double low,@Param("high") double high)  throws Exception; //取得订单单价在low和high之间的订单列表
	public int selectCountByPriceScope(@Param("low") double low,@Param("hight") double hight) throws Exception; //取得价格在low和high之间所有的订单的个数。
	public double selectAmountByProduct(String productName) throws Exception; //取得指定产品的订单累计金额。 每个订单的金额=单价*数量
}
