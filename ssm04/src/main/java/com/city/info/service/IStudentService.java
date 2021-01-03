package com.city.info.service;

import java.util.List;

import com.city.info.model.CourseModel;
import com.city.info.model.StudentModel;

//学生的业务接口
public interface IStudentService {
	public void add(StudentModel em) throws Exception; //增加学生
	public void addCourse(int studentNo, int[] courseNos) throws Exception; //为学生增加选课。
	public List<CourseModel> getCoursesByStudent(int studentNo) throws Exception; //取得指定学生的选课列表
	public List<CourseModel> getCoursesWithoutSelected() throws Exception; //取得没有被选的选课列表
	public int getStudentCountBySexAndCourse(String sex, int courseNo ) throws Exception; //取得性别和课程的学生人数
	public List<StudentModel> getListBySearchCondition(String sex, String nameKeyword, int lowAge, int highAge) throws Exception; //按检索条件取得员工列表，并取得关联的班级对象。
	public List<StudentModel> getListBySearchCondition01(String sex, String nameKeyword, int lowAge, int highAge) throws Exception; //按检索条件取得学生列表，并取得关联的班级对象和关联的课程集合。
}
