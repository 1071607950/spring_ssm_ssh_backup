package com.city.info.model;

import org.apache.ibatis.type.Alias;

//学生的Model类
@Alias("Student")
public class StudentModel {
	private int no=0;
	private String name=null;
	private int cno=0;
	private int age=0;
	private String sex=null;
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
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
