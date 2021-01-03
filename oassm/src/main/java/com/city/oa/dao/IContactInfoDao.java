package com.city.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.city.oa.model.ContactInfoModel;
//员工联系信息DAO接口
@Mapper
public interface IContactInfoDao {

	//增加员工联系信息
	public void insert(ContactInfoModel am) throws Exception;
	//修改员工联系信息
	public void update(ContactInfoModel am) throws Exception;
	//删除员工联系信息
	public void delete(ContactInfoModel am) throws Exception;
	//取得指定员工ID的联系信息对象
	public ContactInfoModel selectById(String id) throws Exception;
	//取得所有的联系信息对象列表
	public List<ContactInfoModel> selectListByAll() throws Exception;
}
