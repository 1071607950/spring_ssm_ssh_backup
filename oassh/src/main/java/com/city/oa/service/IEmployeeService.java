package com.city.oa.service;

import java.util.Date;
import java.util.List;

import com.city.oa.model.BehaveModel;
import com.city.oa.model.EmployeeModel;

//员工业务接口
public interface IEmployeeService {

	//==========================持久化编程--CUD 增加 修改 删除===============================================
	public void add(EmployeeModel em) throws Exception;
	public void modify(EmployeeModel em) throws Exception;
	public void delete(EmployeeModel em) throws Exception;
	//修改员工密码的方法
	public void changePassword(String id,String password) throws Exception;
	
	//==========================持久化编程--R查询=========================================================
	//取得指定的员工信息
	public EmployeeModel getById(String id) throws Exception;
	//取得所有部门类别，不分页模式
	public List<EmployeeModel> getListByAll() throws Exception;
	//取得所有部门类别，分页模式
	public List<EmployeeModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得所有部门个数
	public int getCountByAll() throws Exception;
	//取得部门的页数,参数：每页显示的记录个数
	public int getPageCountByAll(int rows) throws Exception;
	//取得指定部门的员工列表, 参数：departmentNo 部门编号
	public List<EmployeeModel> getListByDepartment(int departmentNo) throws Exception;
	//根据综合检索条件取得员工列表，演示动态SQL的映射
	//按姓名模糊检索，按性别检索，
	//按年龄区间检索，按加入公司日期区间检索
	public List<EmployeeModel> getListBySearchCondition(String name, String sex, int minAge, int maxAge, Date startJoinDate, Date endJoinDate) throws Exception;
		
	
	
	
	//======================操作员工爱好的方法=============================================
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
	public boolean chechHaveBehave(String employeeId,int behaveNo) throws Exception;
	
	//===================HQL和Query API执行查询的方法=================================================
	//取得员工年龄在min和max之间的员工列表
	public List<EmployeeModel> getListByAgeScope(int min,int max) throws Exception;
	
	
	//===========================内关联查询测试方法==================================================
	//取得每个员工和它关联的部门对象,使用内关联查询，取得员工对象和关联的部门对象
	public List<Object[]> getListAndDepartment() throws Exception;
	
	
	
	
	
	
	
	//===========================外关联查询测试方法==================================================
	public List<EmployeeModel> getListUsingLeftOuterJoinWithDepartment() throws Exception;
	
	//使用外关联查询，取得每个员工姓名和关联的部门的名称，即使没有关联的部门也查询
	public List<Object[]> getEmployeeNameAndDepartmentNameList() throws Exception;
	
	
	
	
	//===========================子查询测试方法==================================================
	//查询没有任何爱好的员工列表
	public List<EmployeeModel> getListWithoutAnyBehaves() throws Exception;
	
	//取得部门的工资大于本部门平均工资的员工列表
	public List<EmployeeModel> getListByGreateThanDepartmentSalaryAvg() throws Exception;
	
	
	
	
	
	
	
	
	
}
