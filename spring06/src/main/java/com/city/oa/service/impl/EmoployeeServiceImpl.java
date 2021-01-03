package com.city.oa.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IEmployeeService;

@Service("employeeService")
@Transactional
public class EmoployeeServiceImpl implements IEmployeeService {
	
	private SessionFactory sessionFactory=null;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(rollbackFor={Exception.class})
	public void add(EmployeeModel em) throws Exception {
		sessionFactory.getCurrentSession().save(em);
	}

	@Override
	@Transactional(readOnly = true)
	public EmployeeModel getById(String id) throws Exception {
		return sessionFactory.getCurrentSession().get(EmployeeModel.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeModel> getListByAgeScope(int min, int max) throws Exception {
		return sessionFactory.getCurrentSession()
				.createQuery("select em from EmployeeModel em where em.age between :min and :max",EmployeeModel.class)
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeModel> getListByAllWithPage(int start, int rows) throws Exception {
		return sessionFactory.getCurrentSession()
				.createQuery("select em from EmployeeModel em",EmployeeModel.class)
				.setFirstResult(start)
				.setMaxResults(rows)
				.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public double getTotalSalaryByAll() throws Exception {
		return sessionFactory.getCurrentSession()
				.createQuery("select sum(em.salary) from EmployeeModel em",Double.class)
				.getSingleResult();
	}

	@Override
	@Transactional(readOnly=true,isolation = Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED)
	public int getAvgAgeByAll() throws Exception {
		return sessionFactory.getCurrentSession()
				.createQuery("select avg(em.age) from EmployeeModel em",Double.class)
				.getSingleResult()
				.intValue();
	}

}
