package com.city.oa.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.city.oa.factory.HibernateFactory;
import com.city.oa.model.DepartmentModel;
import com.city.oa.service.IDepartmentService;
//部门的业务实现类
public class DepartmentServiceImplWithHibernate implements IDepartmentService {
	@Override
	public void add(DepartmentModel dm) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.save(dm);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
	}
	@Override
	public void modify(DepartmentModel dm) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(DepartmentModel dm) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public DepartmentModel getByNo(int no) throws Exception{
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		DepartmentModel dm=session.get(DepartmentModel.class, no);
		//提交事务
		tx.commit();
		//关闭Session
		session.close();
		return dm;
	}
	@Override
	public List<DepartmentModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<DepartmentModel> getListByAllWithPage(int rows, int page) throws Exception {
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
	public DepartmentModel getByNoWithEmployees(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<DepartmentModel> getListWithEmployees() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Object[]> getListAndEmployee() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<DepartmentModel> getListWithOrWithoutEmployees() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Object[]> getDepartmentAndTotalSalary(double avgLow, double avgHigh) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getMaxAvgSalaryOfDepartment() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
