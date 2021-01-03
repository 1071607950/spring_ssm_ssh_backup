package com.city.info.service;

import java.util.List;

import com.city.info.model.StudentModel;

//学生的业务接口
public interface IStudentService {
	public void add(StudentModel em) throws Exception; //增加学生
	public List<StudentModel> getListByClass(int classNo)  throws Exception; //取得指定班级的学生列表
	public double getAvgAgeByClass(int classNo)  throws Exception; // 参数:班级编号, 返回此班级的的所有学生的平均年龄。
	public List<StudentModel> getListByAll() throws Exception; //取得所有学生列表。
	public List<StudentModel> getListByAllWithPage(int start,int rows) throws Exception; //取得所有学生列表，分页模式，参数：起始位置，参数：个数。
	public List<StudentModel> getListByCondition(int classNo,String sex, int lowAge, int highAge) throws Exception; //按检索条件取得学生列表。
	public double getAvgAgeByCondition(int classNo,String sex, int lowAge, int highAge) throws Exception; //取得指定条件的员工平均年龄。
}
