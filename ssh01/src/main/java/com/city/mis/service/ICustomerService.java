package com.city.mis.service;

import com.city.mis.model.CustomerModel;

//部门的业务接口
public interface ICustomerService {
	public void add(CustomerModel cm) throws Exception;
	public void modify(CustomerModel cm) throws Exception;
}
