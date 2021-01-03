package com.city.erp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Product")
public class ProductModel implements Serializable {
	
	private int no=0;
	private String name=null;
	private Date date=null;
	private double price=0;
	private int qty=0;
	private List<AreaModel> areas=null;
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
	public List<AreaModel> getAreas() {
		return areas;
	}
	public void setAreas(List<AreaModel> areas) {
		this.areas = areas;
	}
}
