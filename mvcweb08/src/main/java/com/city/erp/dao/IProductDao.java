package com.city.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.city.erp.model.ProductModel;

@Mapper
public interface IProductDao {
	
	public void insert(ProductModel sm) throws Exception; //增加产品
	public List<ProductModel> selectListByAll() throws Exception; //取得所有的产品列表
}
