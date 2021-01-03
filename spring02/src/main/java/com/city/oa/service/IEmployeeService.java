package com.city.oa.service;

import java.util.List;

import com.city.oa.model.EmployeeModel;

//产品的业务接口
public interface IEmployeeService {
	public void add(EmployeeModel em) throws Exception;
	public boolean validate(String id,String password)  throws Exception; //验证员工账号和密码是否合法
	public List<EmployeeModel> getListByAgeScope(int min, int max)  throws Exception;
	public List<EmployeeModel> getListByAllWithPage(int rows, int page);  //分页方式取得员工列表
	public double getTotalSalaryByAll() throws Exception; //取得所有员工的汇总工资
	public int getAvgAgeByAll() throws Exception; //取得所有员工的平均年龄
}
