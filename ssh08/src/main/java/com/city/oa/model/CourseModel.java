package com.city.oa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//课程Model类
@Entity
@Table(name="oa_course")
public class CourseModel implements Serializable {
	@Id
	@Column(name="CNo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no=0;
	@Column(name="CName")
	private String name=null;
	@ManyToMany(mappedBy="courses",fetch=FetchType.LAZY)
	private Set<StudentModel> students=null;
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
	public Set<StudentModel> getStudents() {
		return students;
	}
	public void setStudents(Set<StudentModel> students) {
		this.students = students;
	}
}
