package com.city.info.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

//学生的Model类
@Alias("Student")
public class StudentModel {
	private int no=0;
	private String name=null;
	private int age=0;
	private String sex=null;
	private ClassModel cla=null;
	private List<CourseModel> courses=null;
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
	public ClassModel getCla() {
		return cla;
	}
	public void setCla(ClassModel cla) {
		this.cla = cla;
	}
	public List<CourseModel> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseModel> courses) {
		this.courses = courses;
	}
}
