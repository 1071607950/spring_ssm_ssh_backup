package com.city.oa.model;

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
//员工地址Model类
@Entity
@Table(name="oa_employeeaddress")
public class AddressModel implements Serializable {
	@Id
	@Column(name="EMPID")
	//定义主键生成策略,使用外键策略模式,其值取值关联属性employee对应的Model的主键
	@GenericGenerator(name="PK_GEN",strategy="foreign",parameters={@Parameter(name="property",value="employee")})
	//引用上面定义的外键生成器,作为id的值生成器
	@GeneratedValue(generator="PK_GEN")
	private String id=null;//员工账号 主键同时是外键
	private String city=null;//城市
	private String address=null;//地址
	private String postcode=null;//邮政编码
	//一对一关联(共享主键模式)
	@OneToOne
	@PrimaryKeyJoinColumn
	private EmployeeModel employee=null;//外键关联的员工
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public EmployeeModel getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}
	
}
