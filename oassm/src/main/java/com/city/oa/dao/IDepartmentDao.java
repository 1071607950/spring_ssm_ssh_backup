package com.city.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.city.oa.model.DepartmentModel;

//部门的DAO接口
@Mapper
public interface IDepartmentDao {
	//增加新部门
	//@Insert("insert into oa_department (DEPTCODE,DEPTNAME) values (#{code},#{name})")
	public int insert(DepartmentModel dm) throws Exception;
	//修改部门
	
	public void update(DepartmentModel dm) throws Exception;
	//删除部门
	public void delete(DepartmentModel dm) throws Exception;
	//查询部门-查询单个部门,不取关联的员工集合对象
	//@Select("select DEPTNO no, DEPTCODE code, DEPTNAME name from oa_department where DEPTNO=#{no}")
	public DepartmentModel selectByNo(int no) throws Exception;
	//取得指定的部门，并同时取得其关联的员工集合属性
	public DepartmentModel selectByNoWithEmployess(int no) throws Exception;
	
	
	//查询部门-查询多个部门，返回部门列表
	public List<DepartmentModel> selectListByAll() throws Exception;
	//查询部门-查询多个部门，返回部门列表, 同时取得关联的员工集合属性
	public List<DepartmentModel> selectListByAllWithEmployees() throws Exception;
		
	
	//查询部门-查询多个部门，返回部门列表
	public List<DepartmentModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//查询所有部门的个数
	public int selectCountByAll() throws Exception;
	
	
	

}
