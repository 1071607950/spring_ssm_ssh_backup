package com.city.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city.erp.model.ProductModel;

@Mapper
public interface IProductDao {
	
	public void insert(ProductModel sm) throws Exception; //增加产品
	public List<ProductModel> selectListByPriceWithPage(@Param("low") double low,@Param("high") double high,@Param("start") int start,@Param("rows") int rows) throws Exception; //取得所有的产品列表, 参数start:起始位置 rows:结果个数
	public int selectCountByPrice(@Param("low") double low,@Param("high") double high) throws Exception; //取得价格在low和high之间的产品的个数。
}
