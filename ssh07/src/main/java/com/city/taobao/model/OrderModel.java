package com.city.taobao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//订单Model类
@Entity
@Table(name="tb_orders")
public class OrderModel implements Serializable {
	@Id
	@Column(name="OrderNo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no=0;
	@Column(name="OrderDATE")
	private Date date=null;
	@Column(name="Price")
	private double price=0;
	@Column(name="QTY")
	private int qty=0;
	@Column(name="CNAME")
	private String name=null;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
