package com.city.erp.service;

import java.util.List;


import com.city.erp.model.AreaModel;
import com.city.erp.model.ProductModel;

public interface IProductService {
	public void add(ProductModel pm) throws Exception; //增加产品
	public void addAreas(int pno, int[] areas) throws Exception; //为产品增加区域
	public List<AreaModel> getAreaListByProduct(int productNo) throws Exception; //取得指定产品的区域列表
	public List<ProductModel> getProductListWithoutArea() throws Exception; //取得没有区域的产品列表。
}
