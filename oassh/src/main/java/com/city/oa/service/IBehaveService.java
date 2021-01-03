package com.city.oa.service;

import java.util.List;

import com.city.oa.model.BehaveModel;

//爱好业务接口
public interface IBehaveService {

	public void add(BehaveModel bm) throws Exception;
	public void modify(BehaveModel bm) throws Exception;
	public void delete(BehaveModel bm) throws Exception;
	public BehaveModel getByNo(int no) throws Exception;
	//取得所有部门类别，不分页模式
	public List<BehaveModel> getListByAll() throws Exception;
	//取得所有部门类别，分页模式
	public List<BehaveModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得所有爱好的个数
	public int getCountByAll() throws Exception;
	//取得所有爱好的显示页数
	public int getPageCountByAll(int rows) throws Exception;
	
}
