package com.city.oa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//学生Model类
@Entity
@Table(name="oa_student")
public class StudentModel implements Serializable {
	@Id
	@Column(name="SSID")
	private String id=null;
	@Column(name="SName")
	private String name=null;
	@Column(name="SEX")
	private String sex=null;
	@Column(name="AGE")
	private int age=0;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="oa_studentcourse",
			joinColumns={@JoinColumn(name="SSID",referencedColumnName="SSID")},
			inverseJoinColumns= {@JoinColumn(name="CNo",referencedColumnName="CNo")}
	)
	private Set<CourseModel> courses=null;
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
	public Set<CourseModel> getCourses() {
		return courses;
	}
	public void setCourses(Set<CourseModel> courses) {
		this.courses = courses;
	}
}
