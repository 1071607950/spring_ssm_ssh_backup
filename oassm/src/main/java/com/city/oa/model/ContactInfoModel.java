package com.city.oa.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
//员工的联系信息Model类 与员工Model类 一对一关联关系
@Alias("ContactInfo")
public class ContactInfoModel implements Serializable {

	private int no=0;
	private String mail=null;
	private String mobile=null;
	private String qq=null;
	//一对一关联关系
	private EmployeeModel employee=null;
		
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public EmployeeModel getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}
	
	
}
