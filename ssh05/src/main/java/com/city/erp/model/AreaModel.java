package com.city.erp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//区域Model类
@Entity
@Table(name="erp_areas")
public class AreaModel implements Serializable {
	@Id
	@Column(name="ANo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no=0;
	@Basic
	@Column(name="AName")
	private String name=null;
	//多对多关联
	@ManyToMany(mappedBy="areas",fetch=FetchType.LAZY)
	private Set<ProductModel> products=null;
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
	public Set<ProductModel> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductModel> products) {
		this.products = products;
	}
}
