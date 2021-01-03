package com.city.mis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//部门Model类
@Entity
@Table(name="customer")
public class CustomerModel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CNO")
	private int no=0;
	@Column(name="CCODE")
	private String code=null;
	@Column(name="CNAME")
	private String name=null;
	@Column(name="STAFFNUM")
	private int num;
	@Column(name="CREATEDATE")
	private Date date;
	@Column(name="YEARSALES")
	private Double yearsales;
	@Column(name="Address")
	private String address;
	@Column(name="TEL")
	private String tel;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getYearsales() {
		return yearsales;
	}
	public void setYearsales(Double yearsales) {
		this.yearsales = yearsales;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
