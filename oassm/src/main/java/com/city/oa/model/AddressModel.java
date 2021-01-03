package com.city.oa.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
//员工地址Model类
@Alias("Address")
public class AddressModel implements Serializable {
	
	private String id=null; //员工账号 主键同时是外键
	private String city=null; //城市
	private String address=null; //地址
	private String postcode=null; //邮政编码
	private EmployeeModel employee=null; //外键关联的员工，一对一
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public EmployeeModel getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}
	
	

}
