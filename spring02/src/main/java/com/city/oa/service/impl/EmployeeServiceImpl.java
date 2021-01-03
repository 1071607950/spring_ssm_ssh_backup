package com.city.oa.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {
	private SessionFactory sessionFactory=null;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(EmployeeModel em) throws Exception {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.save(em);
		ts.commit();
		session.close();
	}

	@Override
	public boolean validate(String id, String password) throws Exception {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		String hql="select count(em.id) from EmployeeModel em where em.id=:id and em.pass=:pass";
		Query<Long> query=session.createQuery(hql,Long.class);
		query.setParameter("id", id);
		query.setParameter("pass", password);
		boolean result=query.getSingleResult()!=0;
		ts.commit();
		session.close();
		return result;
	}

	@Override
	public List<EmployeeModel> getListByAgeScope(int min, int max) throws Exception {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		String hql="from EmployeeModel em where em.age between :min and :max";
		Query<EmployeeModel> query=session.createQuery(hql,EmployeeModel.class);
		query.setParameter("min", min);
		query.setParameter("max", max);
		List<EmployeeModel> lists=query.getResultList();
		ts.commit();
		session.close();
		return lists;
	}

	@Override
	public List<EmployeeModel> getListByAllWithPage(int rows, int page) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		String hql="from EmployeeModel em";
		Query<EmployeeModel> query=session.createQuery(hql,EmployeeModel.class);
		query.setFirstResult(rows*(page-1));
		query.setMaxResults(rows);
		List<EmployeeModel> lists=query.getResultList();
		ts.commit();
		session.close();
		return lists;
	}

	@Override
	public double getTotalSalaryByAll() throws Exception {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		String hql="select sum(em.salary) from EmployeeModel em";
		Query<Double> query=session.createQuery(hql,Double.class);
		double sum=query.getSingleResult();
		ts.commit();
		session.close();
		return sum;
	}

	@Override
	public int getAvgAgeByAll() throws Exception {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		String hql="select avg(em.age) from EmployeeModel em";
		Query<Double> query=session.createQuery(hql,Double.class);
		Double avg=query.getSingleResult();
		ts.commit();
		session.close();
		return avg.intValue();
	}
	

}
