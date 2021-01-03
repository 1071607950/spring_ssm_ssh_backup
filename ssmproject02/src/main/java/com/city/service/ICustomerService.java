package com.city.service;

import com.city.pojo.CustomerModel;

import java.util.List;

public interface ICustomerService {

    public int addCus(CustomerModel customerModel);

    public int modifyCus(CustomerModel customerModel);

    public int deleteCus(int id);

    public CustomerModel selectCusById(int id);

    public List<CustomerModel> selectAll();
}
