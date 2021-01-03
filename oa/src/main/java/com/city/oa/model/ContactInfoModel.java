package com.city.oa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//员工的联系信息Model类与员工Model类一对一关联关系
@Entity
@Table(name="oa_employeecontactinfo")
public class ContactInfoModel implements Serializable {
	@Id
	@Column(name="CINO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no=0;
	
	private String mail=null;
	private String mobile=null;
	private String qq=null;
	@OneToOne
	@JoinColumn(name="EMPID")
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
