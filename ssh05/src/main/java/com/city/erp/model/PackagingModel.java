package com.city.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


//包装Model类
@Entity
@Table(name="erp_productpackaging")
public class PackagingModel implements Serializable {
	@Id
	@Column(name="PNO")
	//定义主键生成策略,使用外键策略模式,其值取值关联属性product对应的Model的主键
	@GenericGenerator(name="PK_GEN",strategy="foreign",parameters={@Parameter(name="property",value="product")})
	//引用上面定义的外键生成器,作为id的值生成器
	@GeneratedValue(generator="PK_GEN")
	private int no=0;
	@Column(name="PTYPE")
	private String type=null;
	@Column(name="PSIZE")
	private int size=0;
	//一对一关联(共享主键模式)
	@OneToOne
	@PrimaryKeyJoinColumn
	private ProductModel product=null;//外键关联的产品
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
}
