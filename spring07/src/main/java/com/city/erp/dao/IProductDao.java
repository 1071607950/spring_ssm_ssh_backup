package com.city.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city.erp.model.AreaModel;
import com.city.erp.model.ProductModel;

@Mapper
public interface IProductDao {
	
	public void insert(ProductModel pm) throws Exception; //增加产品
	public void insertAreas(@Param("pno") int pno,@Param("areas") int[] areas) throws Exception; //为产品增加区域
	public List<AreaModel> selectAreaListByProduct(int productNo) throws Exception; //取得指定产品的区域列表
	public List<ProductModel> selectProductListWithoutArea() throws Exception; //取得没有区域的产品列表
	
}
