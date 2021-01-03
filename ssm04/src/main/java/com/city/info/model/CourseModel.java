package com.city.info.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

//课程Model类
@Alias("Course")
public class CourseModel {
	private int no=0;
	private String name=null;
	private List<StudentModel> students=null;
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
	public List<StudentModel> getStudents() {
		return students;
	}
	public void setStudents(List<StudentModel> students) {
		this.students = students;
	}
}
