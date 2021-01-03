package com.city.oa.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.city.oa.model.DepartmentModel;
import com.city.oa.service.IDepartmentService;

//部门业务实现类 使用SSH模式


@Service("departmentServiceWithSSH")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.REPEATABLE_READ,rollbackFor= {Exception.class})
public class DepartmentServiceImplWithSSH implements IDepartmentService {
	@Autowired
	private SessionFactory sessionFactory=null;

	@Override
	public void add(DepartmentModel dm) throws Exception {
		sessionFactory.getCurrentSession().save(dm);
	}

	@Override
	public void modify(DepartmentModel dm) throws Exception {
		sessionFactory.getCurrentSession().update(dm);

	}

	@Override
	public void delete(DepartmentModel dm) throws Exception {
		sessionFactory.getCurrentSession().delete(dm);

	}

	@Override
	@Transactional(readOnly=true)
	public DepartmentModel getByNo(int no) throws Exception {
		
		return sessionFactory.getCurrentSession().get(DepartmentModel.class, no);
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepartmentModel> getListByAll() throws Exception {
		
		return sessionFactory.getCurrentSession().createQuery("from DepartmentModel dm",DepartmentModel.class).getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepartmentModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return sessionFactory
				.getCurrentSession()
				.createQuery("from DepartmentModel dm",DepartmentModel.class)
				.setFirstResult(rows*(page-1))
				.setMaxResults(rows)
				.getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public int getCountByAll() throws Exception {
		
		return sessionFactory
				.getCurrentSession()
				.createQuery("select count(dm.no) from DepartmentModel dm",Long.class)
				.uniqueResult()
				.intValue();
	}

	@Override
	@Transactional(readOnly=true)
	public int getPageCountByAll(int rows) throws Exception {
		
		return 0;
	}

	@Override
	@Transactional(readOnly=true)
	public DepartmentModel getByNoWithEmployees(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
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
