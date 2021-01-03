package com.city.oa.service;

import java.util.Date;
import java.util.List;

import com.city.oa.model.EmployeeModel;

//员工的业务层接口
public interface IEmployeeService {
	
	//增加员工，同时增加地址，联系方式
	public void add(EmployeeModel dm) throws Exception;
	//修改员工，同时修改地址，联系方式
	public void modify(EmployeeModel dm) throws Exception;
	//删除员工，同时删除地址，联系方式
	public void delete(EmployeeModel dm) throws Exception;
	//取得指定的员工，不取关联的对象
	public EmployeeModel getById(String id) throws Exception;
	public EmployeeModel getByIdWithPhoto(String id) throws Exception;

	//取得指定的员工，并取得关联的部门对象
	public EmployeeModel getByIdWithDepartment(String id) throws Exception;
	
	//取得指定的员工，取关联的部门,地址，联系信息，爱好等关联对象
	public EmployeeModel getByIdWithDepartmentAddressContactInfoBehaves(String id) throws Exception;
	
	//取得员工列表，不分页模式，不取关联的员工对象
	public List<EmployeeModel> getListByAll() throws Exception;
	
	//取得员工列表，不分页模式，抓取取关联的员工对象
	public List<EmployeeModel> getListByAllWithDepartment() throws Exception;
	
	//取得员工列表，分页模式
	public List<EmployeeModel> getListByAllWithPage(int rows,int page) throws Exception;
	
	//根据综合检索条件取得员工列表，演示动态SQL的映射
	//按姓名模糊检索，按性别检索，
	//按年龄区间检索，按加入公司日期区间检索
	public List<EmployeeModel> getListBySearchCondition(String name, String sex, int minAge, int maxAge, Date startJoinDate, Date endJoinDate) throws Exception;
		
	//================================员工的爱好相关方法===================================================
	//为员工增加爱好，单个爱好, 参数：员工ID，爱好编号
	public void addBehave(String id,int behaveNo) throws Exception;
	//为员工增加爱好，多个爱好,参数:员工ID，爱好编号数组
	public void addBehaves(String id,int[] behaveNos) throws Exception;
	
	//取得有指定多个爱好的员工列表，爱好通过数组参数确定
	public List<EmployeeModel> getListByBehaves(int[] behaves) throws Exception;
	
	
	

}
