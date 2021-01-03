package com.city.oa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//部门Model类
@Entity
@Table(name="oa_department")
public class DepartmentModel implements Serializable {
	@Id
	@Column(name="DEPTNO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no=0;
	@Basic
	@Column(name="DEPTCODE")
	private String code=null;
	@Column(name="DEPTNAME",updatable=false)
	private String name=null;
	
	//一对多的关联关系
	@OneToMany(mappedBy="department",cascade= {CascadeType.REMOVE},fetch=FetchType.LAZY)
	private Set<EmployeeModel> employees=null;//部门关联的员工对象(多个)
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
	public Set<EmployeeModel> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<EmployeeModel> employees) {
		this.employees = employees;
	}
	
}
