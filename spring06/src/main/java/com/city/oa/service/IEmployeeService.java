package com.city.oa.service;

import java.util.List;

import com.city.oa.model.EmployeeModel;

//员工的业务接口
public interface IEmployeeService {
	public void add(EmployeeModel em) throws Exception;
	public EmployeeModel getById(String id)  throws Exception;
	public List<EmployeeModel> getListByAgeScope(int min, int max)  throws Exception; //取得年龄在min和max之间的员工列表
	public List<EmployeeModel> getListByAllWithPage(int start, int rows)  throws Exception; //分页方式取得员工列表， start 起始位置， rows：个数
	public double getTotalSalaryByAll() throws Exception; //取得所有员工的汇总工资 
	public int getAvgAgeByAll() throws Exception; //取得所有员工的平均年龄
}
