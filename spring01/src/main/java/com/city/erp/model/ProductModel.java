package com.city.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//产品Model类
@Entity
@Table(name="erp_product1")
public class ProductModel implements Serializable {
	@Id
	@Column(name="PID")
	private String id=null;
	@Column(name="PName")
	private String name=null;
	@Column(name="MODEL")
	private String model=null;
	@Column(name="PRICE")
	private Double price=null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
