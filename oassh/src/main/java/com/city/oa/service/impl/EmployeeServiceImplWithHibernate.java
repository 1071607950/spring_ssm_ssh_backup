package com.city.oa.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.city.oa.factory.HibernateFactory;
import com.city.oa.model.AddressModel;
import com.city.oa.model.BehaveModel;
import com.city.oa.model.DepartmentModel;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IEmployeeService;
//员工业务实现类
//@Service("employeeServiceWithHibernate")
public class EmployeeServiceImplWithHibernate implements IEmployeeService {
	//增加员工
	@Override
	public void add(EmployeeModel em) throws Exception {
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.save(em);		
		//提交事务
		tx.commit();
		//关闭session
		session.close();

	}
	//修改员工
	@Override
	public void modify(EmployeeModel em) throws Exception {
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成对员工的修改
		session.update(em);
		//提交事务
		tx.commit();
		//关闭session
		session.close();
	}

	@Override
	public void delete(EmployeeModel em) throws Exception {
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.delete(em);		
		//提交事务
		tx.commit();
		//关闭session
		session.close();

	}
	
	//修改员工密码的方法,只修改员工的密码
	public void changePassword(String id,String password) throws Exception{
		
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得员工的对象
		EmployeeModel em=session.get(EmployeeModel.class, id);
		//em已经处于持久态，直接更新属性即可，不需要再执行update方法
		em.setPassword(password);
			
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();

		
	}
		
	//==========================持久化编程--R查询=========================================================
	@Override
	public EmployeeModel getById(String id) throws Exception {
		
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定ID的员工对象，执行延迟检索，返回代理对象，只有主属性值。
		EmployeeModel em=session.get(EmployeeModel.class, id);
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		
		return em;
	}

	@Override
	public List<EmployeeModel> getListByAll() throws Exception {
		
		return null;
	}

	@Override
	public List<EmployeeModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return null;
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return 0;
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		
		return 0;
	}
	//取得指定部门的员工列表
	@Override
	public List<EmployeeModel> getListByDepartment(int departmentNo) throws Exception {
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的部门
		DepartmentModel dm=session.get(DepartmentModel.class, departmentNo);
		//取得部门的员工集合(一对多关联属性）
		Set<EmployeeModel> employeeSet=dm.getEmployees();
		//将Set集合转换为List类型
		List<EmployeeModel> employeeList=new ArrayList<EmployeeModel>(employeeSet);
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		return employeeList;
	}
	
	//======================操作员工爱好的方法=============================================
	//为指定的员工增加指定的爱好，参数:employeeId:员工账号， behaveNo:爱好编号， 
	@Override
	public void addBehave(String employeeId, int behaveNo) throws Exception //增加单个爱好的方法
	{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的员工对象
		EmployeeModel em=session.get(EmployeeModel.class, employeeId);
		//取得指定的爱好对象
		BehaveModel bm=session.get(BehaveModel.class, behaveNo);
		//为员工增加爱好对象
		em.getBehaves().add(bm); //通过向员工的爱好集合里增加爱好对象，实现对关联表记录的增加。
		//bm.getEmployees().add(em); //给爱好的员工集合中增加员工
		//提交事务
		tx.commit();
		//关闭session
		session.close();
	}
	//为指定的员工增加指定的爱好，参数:employeeId:员工账号， behaveNos:爱好编号的数组， 
	@Override
	public void addBehaves(String employeeId, int[] behaveNos) throws Exception //增加多个爱好的方法
	{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的员工对象
		EmployeeModel em=session.get(EmployeeModel.class, employeeId);
		//清除原有的爱好
		em.getBehaves().clear(); 
		for(int behaveNo:behaveNos) {
			//取得指定的爱好对象
			BehaveModel bm=session.get(BehaveModel.class, behaveNo);
			//为员工增加爱好对象
			em.getBehaves().add(bm); //通过向员工的爱好集合里增加爱好对象，实现对关联表记录的增加。
		}
				
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		
	}
	//取得指定员工的爱好列表, 参数：id: 员工账号，
	@Override
	public List<BehaveModel> getBehavesById(String id) throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的员工
		EmployeeModel em=session.get(EmployeeModel.class, id);
		//取得员工的爱好集合(多对多关联属性）
		Set<BehaveModel> behaveSet=em.getBehaves();
		//将Set集合转换为List类型
		List<BehaveModel> behaveList=new ArrayList<BehaveModel>(behaveSet);
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		return behaveList;
		
	}		
	//删除指定员工的指定爱好
	public void deleteBehave(String employeeId, int behaveNo) throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的员工对象
		EmployeeModel em=session.get(EmployeeModel.class, employeeId);
		//取得指定的爱好对象
		BehaveModel bm=session.get(BehaveModel.class, behaveNo);
		//为员工增加爱好对象
		em.getBehaves().remove(bm); //通过从员工的爱好集合里删除爱好对象，实现对关联表记录的删除。
		//提交事务
		tx.commit();
		//关闭session
		session.close();
	}
	//删除指定员工的多个爱好
	public void deleteBehaves(String employeeId, int[] behaveNos) throws Exception{
		
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的员工对象
		EmployeeModel em=session.get(EmployeeModel.class, employeeId);
		for(int behaveNo:behaveNos) {
			//取得指定的爱好对象
			BehaveModel bm=session.get(BehaveModel.class, behaveNo);
			//为员工删除爱好对象
			em.getBehaves().remove(bm);
		}
				
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		
	}
	//删除指定员工的所有爱好
	public void deleteAllBehaves(String employeeId) throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的员工对象
		EmployeeModel em=session.get(EmployeeModel.class, employeeId);
		
		//为员工清空爱好集合，实现所有爱好的删除, 
		em.getBehaves().clear(); 
		//提交事务
		tx.commit();
		//关闭session
		session.close();
	}
	@Override
	public boolean chechHaveBehave(String employeeId, int behaveNo) throws Exception {
		boolean result=false;
		
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的员工和爱好对象
		EmployeeModel em=session.get(EmployeeModel.class, employeeId);
		BehaveModel bm=session.get(BehaveModel.class, behaveNo);
		if(em.getBehaves().contains(bm)) {
			result=true;
		}
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		return result;
	}
	//===================HQL和Query API执行查询的方法=================================================
	//取得员工年龄在min和max之间的员工列表
	@Override
	public List<EmployeeModel> getListByAgeScope(int min, int max) throws Exception {
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//定义查询HQL语句
		String hql="from EmployeeModel em where em.age between :min and :max";
		//创建执行HQL的Query接口对象	
		Query<EmployeeModel> query=session.createQuery(hql,EmployeeModel.class);
		//设置HQL的参数
		query.setParameter("min", min);
		query.setParameter("max", max);
		//提交查询，取得查询结果
		List<EmployeeModel> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		
		return list;
	}
	
	//根据综合检索条件取得员工列表，演示动态SQL的映射
	//按姓名模糊检索，按性别检索，
	//按年龄区间检索，按加入公司日期区间检索
	public List<EmployeeModel> getListBySearchCondition(String name, String sex, int minAge, int maxAge, Date startJoinDate, Date endJoinDate) throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//定义查询HQL语句
		String hql="from EmployeeModel em where 1=1";
		if(name!=null&&name.trim().length()>0) {
			hql=hql+" and em.name like :name";
		}
		if(sex!=null&&sex.trim().length()>0) {
			hql=hql+" and em.sex=:sex";
		}
		if(minAge!=0) {
			hql=hql+"  and em.age>=:minAge";
		}
		if(maxAge!=0) {
			hql=hql+" and em.age<=:maxAge";
		}
		if(startJoinDate!=null) {
			hql=hql+" and em.joinDate>=:startDate";
		}
		if(endJoinDate!=null) {
			hql=hql+" and em.joinDate<=:endDate";
		}
		//创建执行HQL的Query接口对象	
		Query<EmployeeModel> query=session.createQuery(hql,EmployeeModel.class);
		//设置HQL的参数
		if(name!=null&&name.trim().length()>0) {
			query.setParameter("name", "%"+name+"%");
		}
		if(sex!=null&&sex.trim().length()>0) {
			query.setParameter("sex", sex);
		}
		if(minAge!=0) {
			query.setParameter("minAge", minAge);
		}
		if(maxAge!=0) {
			query.setParameter("maxAge", maxAge);
		}
		if(startJoinDate!=null) {
			query.setParameter("startDate", startJoinDate);
		}
		if(endJoinDate!=null) {
			query.setParameter("endDate", endJoinDate);
		}
		//提交查询，取得查询结果
		List<EmployeeModel> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		
		return list;
		
	}
	
	//===========================内关联查询测试方法==================================================
	//取得每个员工和它关联的部门对象,使用内关联查询，取得员工对象和关联的部门对象
	public List<Object[]> getListAndDepartment() throws Exception{
		//取得SessionFactory接口的对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//定义查询HQL语句, 使用内关联方式取得每个员工对象和关联的部门对象
		String hql="from EmployeeModel em inner join em.department dm";
		//创建执行HQL的Query接口对象	
		Query<Object[]> query=session.createQuery(hql,Object[].class);
		//提交查询，取得查询结果
		List<Object[]> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		return list;
	}
	
	
	
	
	
	
	//===========================外关联查询测试方法==================================================
	//测试普通外关联查询案例- 查询所有员工和他关联的部门对象，即使员工没有关联部门对象也查询
	public List<EmployeeModel> getListUsingLeftOuterJoinWithDepartment() throws Exception{
		
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		
		String hql="select em from EmployeeModel em left outer join em.department";
		
		Query<EmployeeModel> query=session.createQuery(hql,EmployeeModel.class);
		
		List<EmployeeModel> list=query.getResultList();
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		
		return list;
	}
	
	//使用外关联查询，取得每个员工姓名和关联的部门的名称，即使没有关联的部门也查询
	public List<Object[]> getEmployeeNameAndDepartmentNameList() throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//普通外关联查询
		String hql="select em.name, dm.name from EmployeeModel em right outer join em.department dm";
		Query<Object[]> query=session.createQuery(hql,Object[].class);
		List<Object[]> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		
		return list;
	}
	
	
	
	//===========================子查询测试方法==================================================
	//查询没有任何爱好的员工列表
	public List<EmployeeModel> getListWithoutAnyBehaves() throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//普通外关联查询
		String hql="from EmployeeModel em where not exists  (from BehaveModel bm inner join bm.employees em01 where em01=em)";
		Query<EmployeeModel> query=session.createQuery(hql,EmployeeModel.class);
		List<EmployeeModel> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		return list;
		
	}
	//取得部门的工资大于本部门平均工资的员工列表
	public List<EmployeeModel> getListByGreateThanDepartmentSalaryAvg() throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//普通外关联查询
		String hql="from EmployeeModel em where em.salary>(select avg(em01.salary) from EmployeeModel em01 where em01.department=em.department)";
		Query<EmployeeModel> query=session.createQuery(hql,EmployeeModel.class);
		List<EmployeeModel> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		return list;
	}
		
	
	//=========================================================================================
	
		

}
