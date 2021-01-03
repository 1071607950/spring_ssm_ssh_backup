package com.city.erp.service;

//产品的业务接口
public interface IProductService {
	public void add(String productId, String name, String model, double price) throws Exception;
}
