package com.city.erp.service;

import java.util.List;

import com.city.erp.model.AreaModel;

//部门的业务接口
public interface IAreaService {
	public List<AreaModel> getListByAll() throws Exception;
}