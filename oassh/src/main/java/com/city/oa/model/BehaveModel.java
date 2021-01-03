package com.city.oa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
//爱好Model类，与员工Model类是多对多关联
@Entity
@Table(name="oa_behave")
public class BehaveModel implements Serializable {
	@Id
	@Column(name="BNO")
	@GeneratedValue()
	private int no=0;
	@Column(name="BNAME")
	private String name=null;
	
	//多对多关联
	/*
	@ManyToMany
	@JoinTable(
			name="oa_employeebehave",
			joinColumns={@JoinColumn(name="BNO",referencedColumnName="BNO")},
			inverseJoinColumns={@JoinColumn(name="EMPID",referencedColumnName="EMPID")}
	)
	*/
	@ManyToMany(mappedBy="behaves") //被动方映射
	private Set<EmployeeModel> employees=null; //指定爱好下的员工集合
	
	
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
	public Set<EmployeeModel> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<EmployeeModel> employees) {
		this.employees = employees;
	}
}
