package com.sap.erp.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//员工Model类
@Entity
@Table(name="sap_product")
public class ProductModel implements Serializable {
	@Id
	@Column(name="pno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no=0;
	@Column(name="pcode")
	private String code=null;
	@Column(name="pname")
	private String name=null;
	@Column(name="pdate")
	private Date date=null;
	@Column(name="unitprice")
	private Double price=null;
	@Column(name="qtyinstock")
	private Double qty=null;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
}
