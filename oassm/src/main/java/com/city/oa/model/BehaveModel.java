package com.city.oa.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.type.Alias;

//爱好Model类，与员工Model类是多对多关联
@Alias("Behave")
public class BehaveModel implements Serializable {
	
	private int no=0;
	private String name=null;
	//多对多关联
	private List<EmployeeModel> employees=null; //指定爱好下的员工集合
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
