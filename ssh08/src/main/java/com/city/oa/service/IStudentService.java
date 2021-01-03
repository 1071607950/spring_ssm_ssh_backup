package com.city.oa.service;

import java.util.List;

import com.city.oa.model.CourseModel;
import com.city.oa.model.StudentModel;

public interface IStudentService {
	public void add(String id,String name,String sex,int age) throws Exception;//增加学生
	public void addCourse(String id,int[] courses) throws Exception; //给指定学生增加多个课程.
	public List<CourseModel> getCourseListByStudent(String id) throws Exception; //取得指定学生的选修课程列表，要求使用关联查询
	public List<CourseModel> getCourseListWithoutSelected() throws Exception; //取得没有被选修的课程列表。
	public int getCourseNumByStudent(String id) throws Exception; //取得指定同学的选修课程个数
	public int getStudentNumByCourse(int courseNo) throws Exception;//取得选修指定课程的学生人数。
	public List<StudentModel> getStudentListWithoutCourse() throws Exception; //取得没有选修任何课程的学生列表。
	public int getStudentAvgAgeBySelectedCourse(int courseNo) throws Exception; //取得选修指定课程的学生的平均年龄。
}
