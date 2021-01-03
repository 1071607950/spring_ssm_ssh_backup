package com.city.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city.erp.model.ProductModel;

@Mapper
public interface IProductDao {
	
	public void insert(ProductModel sm) throws Exception; //增加产品
	public ProductModel selectByNo(int productNo) throws Exception; //取得指定产品
	public List<ProductModel> selectListByAllWithPage(@Param("rows") int rows,@Param("start") int start) throws Exception; //取得所有的产品列表, 分页模式
	public int selectCountByAll() throws Exception; //取得所有产品个数
	public double selectTotalAmountByAll() throws Exception; //取得所有产品的累计金额
}
