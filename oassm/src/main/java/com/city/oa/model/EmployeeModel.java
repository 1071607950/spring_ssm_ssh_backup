
package com.city.oa.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
//员工Model类
@Alias("Employee")
public class EmployeeModel implements Serializable {
	private String id=null;
	private String password=null;
	private String name=null;
	private String sex=null;
	private int age=0;
	private double salary=0;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday=null;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date joinDate=null;
	@JsonIgnore
	private byte[] photo=null; //员工照片
	//private Blob photo=null; 
	private String photoFileName=null; //照片文件名
	private String photoContentType=null; //照片文件类型
	private String cardcode=null; //身份证号
	//多对一关联关系
	private DepartmentModel department=null; //关联的部门， 对应的就是外键字段DEPTNO
	//多对多关联， MyBatis对多推荐使用List类型
	private List<BehaveModel> behaves=null; //员工拥有的爱好集合
	//一对一关联， 员工的地址信息（共享主键方式）
	private AddressModel address=null; 
	//一对一关联，员工的联系信息（独立外键方式，外键唯一且不为空）
	private ContactInfoModel contactInfo=null;
	
	private String photoIsImage=null; //检查照片是否是图片
	
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
	
	public List<BehaveModel> getBehaves() {
		return behaves;
	}
	public void setBehaves(List<BehaveModel> behaves) {
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
	public String getPhotoIsImage() {
		if(photoContentType.startsWith("image")) {
			photoIsImage="Y";
		}
		else {
			photoIsImage="N";
		}
		return photoIsImage;
	}
	public void setPhotoIsImage(String photoIsImage) {
		this.photoIsImage = photoIsImage;
	}
	
	
}
