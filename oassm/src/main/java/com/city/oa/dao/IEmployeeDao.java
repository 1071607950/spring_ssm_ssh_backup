package com.city.oa.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city.oa.model.BehaveModel;
import com.city.oa.model.EmployeeModel;

//员工DAO接口
@Mapper
public interface IEmployeeDao {
	//增加员工 （无图片上传）
	public void insert(EmployeeModel em) throws Exception;
	//增加员工 （有图片上传）
	public void insertWithPhoto(EmployeeModel em) throws Exception;
	//修改员工(无图片）
	public void update(EmployeeModel em) throws Exception;
	//修改员工(有图片）
	public void updateWithPhoto(EmployeeModel em) throws Exception;
	
	//删除员工
	public void delete(EmployeeModel em) throws Exception;
	//取得指定的员工，不取得关联的对象和照片
	public EmployeeModel selectById(String id) throws Exception;
	//取得指定的员工，取得员工的照片
	public EmployeeModel selectByIdWithPhoto(String id) throws Exception;
	
	//取得指定的员工，取得关联的部门对象
	public EmployeeModel selectByIdWithDepartment(String id) throws Exception;
	//取得指定的员工，取得关联的爱好集合对象
	public EmployeeModel selectByIdWithBehaves(String id) throws Exception;
	
	//取得指定的员工，取得关联的地址和联系信息对象
	public EmployeeModel selectByIdWithAddressAndContactInfo(String id) throws Exception;
	
	//取得指定的员工，取得关联的部门，地址和联系信息对象
	public EmployeeModel selectByIdWithDepartmentAndAddressAndContactInfo(String id) throws Exception;
	
	//取得指定的员工，同时抓取关联的部门，地址，联系信息和爱好等关联对象
	public EmployeeModel selectByIdWithDepartmentAndAddressAndContactInfoAndBehaves(String id) throws Exception;
	
	//取得所有的员工列表, 不抓取关联的部门对象
	public List<EmployeeModel> selectListByAll() throws Exception;
	
	//取得所有的员工列表, 抓取关联的部门对象，演示关联查询的映射
	public List<EmployeeModel> selectListByAllWithDepartment() throws Exception;
	
	//取得指定部门的员工列表，参数：部门编号
	public List<EmployeeModel> selectListByDepartment(int departmentNo) throws Exception;
	
	//根据综合检索条件取得员工列表，演示动态SQL的映射
	//按姓名模糊检索，按性别检索，
	//按年龄区间检索，按加入公司日期区间检索
	public List<EmployeeModel> selectListBySearchCondition(@Param("name") String name,@Param("sex") String sex,@Param("minAge") int minAge, int maxAge, Date startJoinDate, Date endJoinDate) throws Exception;
	//================================员工的爱好相关方法===================================================
	//为员工增加爱好，单个爱好, 参数：员工ID，爱好编号
	public void insertBehave(@Param("id") String id,@Param("behaveNo") int behaveNo) throws Exception;
	//为员工增加爱好，多个爱好,参数:员工ID，爱好编号数组
	public void insertBehaves(@Param("id") String id,@Param("behaveNos") int[] behaveNos) throws Exception;
	//删除指定员工的全部爱好
	public void deleteBehaves(String id) throws Exception;
	//取得指定员工的爱好列表
	public List<BehaveModel> selectBehaveListByEmployee(String id) throws Exception;
	//取得有指定多个爱好的员工列表，爱好通过数组参数确定
	public List<EmployeeModel> selectListByBehaves(@Param("behaves") int[] behaves) throws Exception;
	
	
	
	
	
	
	
	
	
}
