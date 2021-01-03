package com.city.erp.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//员工Model类
@Entity
@Table(name="product")
public class ProductModel implements Serializable {
	@Id
	@Column(name="PNO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no=0;
	@Basic
	@Column(name="PNAME")
	private String name=null;
	private String price=null;
	private int qty=0;
	
	//多对一关联关系,外键字段对应的映射
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GNO")
	private CategoryModel category=null;//关联的类别

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	
}
