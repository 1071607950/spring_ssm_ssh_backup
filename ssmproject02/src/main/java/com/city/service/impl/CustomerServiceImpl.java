package com.city.service.impl;

import com.city.mapper.CustomerMapper;
import com.city.pojo.CustomerModel;
import com.city.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public int addCus(CustomerModel customerModel) {
        return customerMapper.addCus(customerModel);
    }

    @Override
    public int modifyCus(CustomerModel customerModel) {
        return customerMapper.updateCus(customerModel);
    }

    @Override
    public int deleteCus(int id) {
        return customerMapper.deleteCus(id);
    }

    @Override
    public CustomerModel selectCusById(int id) {
        return customerMapper.selectById(id);
    }


    @Override
    public List<CustomerModel> selectAll() {
        return customerMapper.selectAll();
    }
}
