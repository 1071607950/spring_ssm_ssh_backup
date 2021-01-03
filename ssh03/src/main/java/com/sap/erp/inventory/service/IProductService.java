package com.sap.erp.inventory.service;

import com.sap.erp.inventory.model.ProductModel;

//部门的业务接口
public interface IProductService {
	public void add(ProductModel pm) throws Exception;
}
