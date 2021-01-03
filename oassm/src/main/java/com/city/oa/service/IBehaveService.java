package com.city.oa.service;

import java.util.List;

import com.city.oa.model.BehaveModel;

//爱好业务接口
public interface IBehaveService {
	//增加爱好
	public int add(BehaveModel dm) throws Exception;
	//修改爱好
	public void modify(BehaveModel dm) throws Exception;
	//删除爱好
	public void delete(BehaveModel dm) throws Exception;
	
	public BehaveModel getByNo(int no) throws Exception;
	
	//取得爱好列表，不分页模式，不取关联的员工对象
	public List<BehaveModel> getListByAll() throws Exception;
	
	//取得爱好列表，不分页模式，抓取取关联的员工对象
	public List<BehaveModel> getListByAllWithEmployees() throws Exception;
	
	//取得爱好列表，分页模式
	public List<BehaveModel> getListByAllWithPage(int rows,int page) throws Exception;
		
	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
	
	
	
	
}
