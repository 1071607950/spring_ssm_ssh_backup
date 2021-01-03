package com.city.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city.oa.model.BehaveModel;
//爱好DAO接口
@Mapper
public interface IBehaveDao {
	//增加爱好
	public void insert(BehaveModel bm) throws Exception;
	//增加爱好
	public void update(BehaveModel bm) throws Exception;
	//增加爱好
	public void delete(BehaveModel bm) throws Exception;
	//取得指定的爱好
	public BehaveModel selectByNo(int no) throws Exception;
	//取得所有的爱好列表，不分页模式
	public List<BehaveModel> selectListByAll() throws Exception;
	
	//取得指定员工的爱好列表
	public List<BehaveModel> selectListByEmployee(String id) throws Exception;
		
	//取得所有的爱好列表, 分页模式
	public List<BehaveModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows ) throws Exception;
	//取得所有的爱好个数
	public int selectCountByAll() throws Exception;
	
	
}
