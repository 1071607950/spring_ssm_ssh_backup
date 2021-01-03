package com.city.oa.service;

import java.util.List;

import com.city.oa.model.BehaveModel;
import com.city.oa.model.EmployeeModel;

//部门的业务接口
public interface IEmployeeService {
	public void add(EmployeeModel em) throws Exception;
	public void modify(EmployeeModel em) throws Exception;
	public void delete(EmployeeModel em) throws Exception;
	public EmployeeModel getById(String id) throws Exception;
	//取得所有部门类别，不分页模式
	public List<EmployeeModel> getListByAll() throws Exception;
	//取得所有部门类别，分页模式
	public List<EmployeeModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得所有部门个数
	public int getCountByAll() throws Exception;
	//取得部门的页数,参数：每页显示的记录个数
	public int getPageCountByAll(int rows) throws Exception;
	//取得指定部门的员工列表, 参数:departmentNo 部门编号
	public List<EmployeeModel> getListByDepartment(int departmentno) throws Exception;
	
	//=========操作员工爱好的方法=============================================
	//为指定的员工增加指定的爱好，参数:employeeId:员工账号， behaveNo:爱好编号， 
	public void addBehave(String employeeId, int behaveNo) throws Exception; //增加单个爱好的方法
	//为指定的员工增加指定的爱好，参数:employeeId:员工账号， behaveNos:爱好编号的数组， 
	public void addBehaves(String employeeId, int[] behaveNos) throws Exception; //增加多个爱好的方法
	//取得指定员工的爱好列表, 参数：id: 员工账号，
	public List<BehaveModel> getBehavesById(String id) throws Exception; //
	//删除指定员工的指定爱好
	public void deleteBehave(String employeeId, int behaveNo) throws Exception;
	//删除指定员工的多个爱好
	public void deleteBehaves(String employeeId, int[] behaveNos) throws Exception;
	//删除指定员工的所有爱好
	public void deleteAllBehaves(String employeeId) throws Exception;
	//检索指定的员工是否有指定的爱好
	public boolean checkHaveBehave(String employeeId, int behaveNo) throws Exception;
	//=====================HQL关联查询方法====================================
	//取得指定的部门，并取得其关联的员工集合
	public EmployeeModel getByNoWithEmployees(int no) throws Exception;
	//取得部门列表，并取得每个部门关联的员工集合，抓取内关联查询
	public List<EmployeeModel> getListWithEmployees() throws Exception;
	
	//=====================HQL外关联查询方法====================================
	//取得所有部门和关联的员工对象，关联员工对象可以没有
	public List<Object[]> getListAndEmployee() throws Exception;
	
	//取得部门列表，并取得每个部门关联的员工集合（没有关联的员工也要查询出来）。 抓取外关联查询
	public List<EmployeeModel> getListWithOrWithoutEmployees() throws Exception;
		
	//=====================HQL分类汇总查询=====================================
	
	//取得每个部门的汇总工资,并且部门平均工资在low和high之间 （having子句案例）
	public List<Object[]> getEmployeeAndTotalSalary(double avgLow, double avgHigh) throws Exception;
	
	//=====================子查询测试方法======================================
	//取得所有部门中平均工资最高的平均工资
	public double getMaxAvgSalaryOfEmployee() throws Exception;
	
}