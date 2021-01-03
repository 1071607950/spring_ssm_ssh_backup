package com.city.info.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city.info.model.CourseModel;
import com.city.info.model.StudentModel;

//学生的DAO接口
@Mapper
public interface IStudentDao {
	public void insert(StudentModel em) throws Exception; //增加学生
	public void insertCourse(@Param("studentNo") int studentNo,@Param("courseNos") int[] courseNos) throws Exception; //为学生增加选课。
	public List<CourseModel> selectCoursesByStudent(int studentNo) throws Exception; //取得指定学生的选课列表
	public List<CourseModel> selectCoursesWithoutSelected() throws Exception; //取得没有被选的选课列表
	public int selectStudentCountBySexAndCourse(@Param("sex") String sex,@Param("courseNo") int courseNo ) throws Exception; //取得性别和课程的学生人数
	public List<StudentModel> selectListBySearchCondition(@Param("sex") String sex,@Param("nameKeyword") String nameKeyword,@Param("lowAge") int lowAge,@Param("highAge") int highAge) throws Exception; //按检索条件取得员工列表，并取得关联的班级对象。
	public List<StudentModel> selectListBySearchCondition01(@Param("sex") String sex,@Param("nameKeyword") String nameKeyword,@Param("lowAge") int lowAge,@Param("highAge") int highAge) throws Exception; //按检索条件取得学生列表，并取得关联的班级对象和关联的课程集合。
}
