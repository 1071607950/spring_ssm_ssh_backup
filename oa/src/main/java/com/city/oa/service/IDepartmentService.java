package com.city.oa.service;

import java.util.List;

import com.city.oa.model.DepartmentModel;

//部门的业务接口
public interface IDepartmentService {
	public void add(DepartmentModel dm) throws Exception;
	public void modify(DepartmentModel dm) throws Exception;
	public void delete(DepartmentModel dm) throws Exception;
	public DepartmentModel getByNo(int no) throws Exception;
	//取得所有部门类别，不分页模式
	public List<DepartmentModel> getListByAll() throws Exception;
	//取得所有部门类别，分页模式
	public List<DepartmentModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得所有部门个数
	public int getCountByAll() throws Exception;
	//取得部门的页数,参数：每页显示的记录个数
	public int getPageCountByAll(int rows) throws Exception;
	
	//=====================HQL关联查询方法====================================
	//取得指定的部门，并取得其关联的员工集合
	public DepartmentModel getByNoWithEmployees(int no) throws Exception;
	//取得部门列表，并取得每个部门关联的员工集合，抓取内关联查询
	public List<DepartmentModel> getListWithEmployees() throws Exception;
	
	//=====================HQL外关联查询方法====================================
	//取得所有部门和关联的员工对象，关联员工对象可以没有
	public List<Object[]> getListAndEmployee() throws Exception;
	
	//取得部门列表，并取得每个部门关联的员工集合（没有关联的员工也要查询出来）。 抓取外关联查询
	public List<DepartmentModel> getListWithOrWithoutEmployees() throws Exception;
		
	//=====================HQL分类汇总查询=====================================
	
	//取得每个部门的汇总工资,并且部门平均工资在low和high之间 （having子句案例）
	public List<Object[]> getDepartmentAndTotalSalary(double avgLow, double avgHigh) throws Exception;
	
	//=====================子查询测试方法======================================
	//取得所有部门中平均工资最高的平均工资
	public double getMaxAvgSalaryOfDepartment() throws Exception;
	
}