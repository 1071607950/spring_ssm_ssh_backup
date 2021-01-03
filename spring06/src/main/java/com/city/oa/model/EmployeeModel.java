package com.city.oa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//员工Model类
@Entity
@Table(name="oa_employee")
public class EmployeeModel implements Serializable {
	@Id
	@Column(name="EID")
	private String id=null;
	@Column(name="EPASS")
	private String pass=null;
	@Column(name="EName")
	private String name=null;
	@Column(name="AGE")
	private int age=0;
	@Column(name="SALARY")
	private double salary=0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
