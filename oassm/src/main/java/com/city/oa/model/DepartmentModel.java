package com.city.oa.model;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.type.Alias;

//部门的Model类
@Alias("Department")
public class DepartmentModel {
	private int no=0;
	private String code=null;
	private String name=null;
	//一对多
	private List<EmployeeModel> employees=null; //部门关联的员工对象（多个）
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<EmployeeModel> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeModel> employees) {
		this.employees = employees;
	}
	
	
}
