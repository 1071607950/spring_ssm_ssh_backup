package com.city.info.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city.info.model.StudentModel;

//学生的DAO接口
@Mapper
public interface IStudentDao {
	public void insert(StudentModel em) throws Exception; //增加学生
	public List<StudentModel> selectListByClass(int classNo)  throws Exception; //取得指定班级的学生列表
	public double selectAvgAgeByClass(int classNo)  throws Exception; // 参数:班级编号, 返回此班级的的所有学生的平均年龄。
	public List<StudentModel> selectListByAll() throws Exception; //取得所有学生列表。
	public  List<StudentModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception; //取得所有学生列表，分页模式，参数：起始位置，参数：个数。
	public  List<StudentModel> selectListByCondition(@Param("classNo") int classNo,@Param("sex") String sex,@Param("lowAge") int lowAge,@Param("highAge") int highAge) throws Exception; //按检索条件取得学生列表。
	public double selectAvgAgeByCondition(@Param("classNo") int classNo,@Param("sex") String sex,@Param("lowAge") int lowAge,@Param("highAge") int highAge) throws Exception; //取得指定条件的员工平均年龄。
}
