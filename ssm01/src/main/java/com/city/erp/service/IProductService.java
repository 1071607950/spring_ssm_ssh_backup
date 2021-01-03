package com.city.erp.service;

import java.util.List;

import com.city.erp.model.ProductModel;

//产品的业务接口
public interface IProductService {
	public void add(ProductModel pm) throws Exception;
	public void modify(ProductModel pm) throws Exception;
	public void delete(ProductModel pm) throws Exception;
	public ProductModel getByNo(int no)  throws Exception;
	public List<ProductModel> getListByAll()  throws Exception;
}
