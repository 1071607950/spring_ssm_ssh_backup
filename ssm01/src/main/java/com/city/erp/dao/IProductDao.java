package com.city.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.city.erp.model.ProductModel;
@Mapper
//部门的DAO接口
public interface IProductDao {
	public void insert(ProductModel em) throws Exception;
	public void update(ProductModel em) throws Exception;
	public void delete(ProductModel em) throws Exception;
	public ProductModel selectById(int id)  throws Exception;
	public List<ProductModel> selectListByAll()  throws Exception;
}
