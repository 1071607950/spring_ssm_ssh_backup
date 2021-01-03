package com.city.erp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//产品Model类
@Entity
@Table(name="erp_products")
public class ProductModel implements Serializable {
	@Id
	@Column(name="PNO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no=0;
	@Basic
	@Column(name="PName")
	private String name=null;
	@Column(name="PDATE")
	private Date date=null;
	@Column(name="UNITPRICE")
	private double price=0;
	@Column(name="QTY")
	private int qty=0;
	//多对多关联
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="erp_productarea",
			joinColumns={@JoinColumn(name="PNo",referencedColumnName="PNo")},
			inverseJoinColumns= {@JoinColumn(name="ANo",referencedColumnName="ANo")}
	)
	private Set<AreaModel> areas=null;
	//一对一关联(共享主键方式)
	@OneToOne(mappedBy="product",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	private PackagingModel packaging=null;
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
	public Set<AreaModel> getAreas() {
		return areas;
	}
	public void setAreas(Set<AreaModel> areas) {
		this.areas = areas;
	}
	public PackagingModel getPackaging() {
		return packaging;
	}
	public void setPackaging(PackagingModel packaging) {
		this.packaging = packaging;
	}
}
