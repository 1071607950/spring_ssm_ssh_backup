package com.city.erp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//部门Model类
@Entity
@Table(name="productcategory")
public class CategoryModel implements Serializable {
	@Id
	@Column(name="GNO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no=0;
	@Basic
	@Column(name="GName")
	private String name=null;
	
	//一对多的关联关系
	@OneToMany(mappedBy="category",cascade= {CascadeType.REMOVE},fetch=FetchType.LAZY)
	private Set<ProductModel> products=null;//部门关联的产品对象(多个)

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
