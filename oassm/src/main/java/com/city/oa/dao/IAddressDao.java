package com.city.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.city.oa.model.AddressModel;
//地址DAO接口
@Mapper
public interface IAddressDao {
	//增加员工地址
	public void insert(AddressModel am) throws Exception;
	//修改员工地址
	public void update(AddressModel am) throws Exception;
	//删除员工地址
	public void delete(AddressModel am) throws Exception;
	//取得指定ID的地址对象
	public AddressModel selectById(String id) throws Exception;
	//取得所有的地址对象列表
	public List<AddressModel> selectListByAll() throws Exception;
	
}
