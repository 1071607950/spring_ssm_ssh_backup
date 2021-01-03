package com.city.oa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.city.oa.factory.HibernateFactory;
import com.city.oa.model.BehaveModel;
import com.city.oa.model.DepartmentModel;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IEmployeeService;
//部门的业务实现类
public class EmployeeServiceImplWithHibernate implements IEmployeeService {
	@Override
	public void add(EmployeeModel em) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.save(em);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}
	@Override
	public void modify(EmployeeModel em) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.update(em);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}
	@Override
	public EmployeeModel getById(String id) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		EmployeeModel em=session.get(EmployeeModel.class, id);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
		return em;
	}
	@Override
	public void delete(EmployeeModel em) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.delete(em);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();		
	}
	@Override
	public List<EmployeeModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EmployeeModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getPageCountByAll(int rows) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<EmployeeModel> getListByDepartment(int departmentno) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		DepartmentModel dm=session.get(DepartmentModel.class, departmentno);
		//取得部门的员工集合(一对多关联属性)
		Set<EmployeeModel> employeeSet=dm.getEmployees();
		//讲Set集合转换为List类型
		List<EmployeeModel> employeeList=new ArrayList<EmployeeModel>(employeeSet);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
		return employeeList;
	}
	@Override
	public void addBehave(String employeeId, int behaveNo) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的员工对象
		EmployeeModel em=session.get(EmployeeModel.class, employeeId);
		//取得指定的爱好对象
		BehaveModel bm=session.get(BehaveModel.class, behaveNo);
		//为员工增加爱好对象
		em.getBehaves().add(bm);//通过向员工的爱好集合里增加爱好对象,实现对关联表记录的增加
		//提交事务
		tx.commit();
		//关闭Session
		session.close();	
	}
	@Override
	public void addBehaves(String employeeId, int[] behaveNos) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
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
			em.getBehaves().add(bm);//通过向员工的爱好集合里增加爱好对象,实现对关联表记录的增加
		}
		//提交事务
		tx.commit();
		//关闭Session
		session.close();	
	}
	@Override
	public List<BehaveModel> getBehavesById(String id) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的员工对象
		EmployeeModel em=session.get(EmployeeModel.class, id);
		//取得员工的爱好集合(多对多关联属性)
		Set<BehaveModel> behaveSet=em.getBehaves();
		//将Set集合转换为List类型
		List<BehaveModel> behaveList=new ArrayList<BehaveModel>(behaveSet);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
		return behaveList;
	}
	@Override
	public void deleteBehave(String employeeId, int behaveNo) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的员工对象
		EmployeeModel em=session.get(EmployeeModel.class, employeeId);
		//取得指定的爱好对象
		BehaveModel bm=session.get(BehaveModel.class, behaveNo);
		//为员工删除爱好对象
		em.getBehaves().remove(bm);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}
	@Override
	public void deleteBehaves(String employeeId, int[] behaveNos) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
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
			//为员工删除爱好对象
			em.getBehaves().remove(bm);
		}
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}
	@Override
	public void deleteAllBehaves(String employeeId) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得指定的员工对象
		EmployeeModel em=session.get(EmployeeModel.class, employeeId);
		//为员工清空爱好集合,实现所有爱好的删除
		em.getBehaves().clear();
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}
	@Override
	public boolean checkHaveBehave(String employeeId, int behaveNo) throws Exception{
		boolean result=false;
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
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
		//关闭Session
		session.close();
		return result;
		
	}
	@Override
	public EmployeeModel getByNoWithEmployees(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EmployeeModel> getListWithEmployees() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Object[]> getListAndEmployee() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EmployeeModel> getListWithOrWithoutEmployees() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Object[]> getEmployeeAndTotalSalary(double avgLow, double avgHigh) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getMaxAvgSalaryOfEmployee() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
