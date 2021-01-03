package com.city.oa.service;

import java.util.List;

import com.city.oa.model.DepartmentModel;

//部门的业务接口
public interface IDepartmentService {
	//增加部门
	public int add(DepartmentModel dm) throws Exception;
	//修改部门
	public void modify(DepartmentModel dm) throws Exception;
	//删除部门
	public void delete(DepartmentModel dm) throws Exception;
	
	//取得指定的部门对象，不取关联的员工集合
	public DepartmentModel getByNoWithoutEmployees(int no) throws Exception;
	//取得指定的部门对象，同时取关联的员工集合
	public DepartmentModel getByNoWithEmployees(int no) throws Exception;
	
	//取得部门列表，不分页模式，不取关联的员工对象
	public List<DepartmentModel> getListByAll() throws Exception;
	
	//取得部门列表，不分页模式，抓取取关联的员工对象
	public List<DepartmentModel> getListByAllWithEmployees() throws Exception;
	
	//取得部门列表，分页模式
	public List<DepartmentModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得所有部门个数
	public int getCountByAll() throws Exception;
	//取得部门页数
	public int getPageCountByAll(int rows) throws Exception;
	
	
	

}
