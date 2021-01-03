package com.city.erp.service;

import com.city.erp.model.ProductModel;

//部门的业务接口
public interface IProductService {
	public int add(ProductModel pm) throws Exception;
	public void addArea(int productNo,int areaNo) throws Exception;
	public void addAreas(int productNo,int[] areaNos) throws Exception;
}