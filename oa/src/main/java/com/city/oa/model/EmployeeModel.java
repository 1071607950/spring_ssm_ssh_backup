package com.city.oa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//员工Model类
@Entity
@Table(name="oa_employee")
public class EmployeeModel implements Serializable {
	@Id
	@Column(name="EMPID")
	private String id=null;
	@Basic
	@Column(name="EMPPASSWORD",nullable=false)
	private String password=null;
	@Column(name="EMPNAME")
	private String name=null;
	@Column(name="EMPSEX")
	private String sex=null;
	private	int age=0;
	private double salary=0;
	private Date birthday=null;
	private Date joinDate=null;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private byte[] photo=null;
	private String photoFileName=null;
	private String photoContentType=null;
	@Column(name="CARDCODE",unique=true,nullable=false,updatable=false)
	private String cardcode=null;//身份证号
	//多对一关联关系,外键字段对应的映射
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DEPTNO",insertable=true,updatable=true,nullable=true)
	private DepartmentModel department=null;//关联的部门
	//多对多关联
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="oa_employeebehave",
			joinColumns={@JoinColumn(name="EMPID",referencedColumnName="EMPID")},
			inverseJoinColumns= {@JoinColumn(name="BNO",referencedColumnName="BNO")}
	)
	private Set<BehaveModel> behaves=null;//员工拥有的爱好集合
	//一对一关联,员工的地址信息(共享主键方式)
	@OneToOne(mappedBy="employee",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	private AddressModel address=null;
	//一对一关联,员工的联系信息(独立外键方式,外键唯一且不为空)
	@OneToOne(mappedBy="employee",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	private ContactInfoModel contactInfo=null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	public DepartmentModel getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentModel department) {
		this.department = department;
	}
	public Set<BehaveModel> getBehaves() {
		return behaves;
	}
	public void setBehaves(Set<BehaveModel> behaves) {
		this.behaves = behaves;
	}
	public AddressModel getAddress() {
		return address;
	}
	public void setAddress(AddressModel address) {
		this.address = address;
	}
	public ContactInfoModel getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfoModel contactInfo) {
		this.contactInfo = contactInfo;
	}
}
