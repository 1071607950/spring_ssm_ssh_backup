package com.city.erp.service;

import java.util.List;

import com.city.erp.model.CategoryModel;

//部门的业务接口
public interface IProductCategotyService {
	public List<CategoryModel> getList() throws Exception;
}