package com.city.oa.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import com.city.oa.model.BehaveModel;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IEmployeeService;
//员工业务实现类（使用Spring集成Hibernate方式实现）
@Service
@Transactional
public class EmployeeServiceImplWithSSH implements IEmployeeService {
	@Autowired
	private SessionFactory sessionFactory=null;
	@Override
	public void add(EmployeeModel em) throws Exception {
		sessionFactory.getCurrentSession().save(em);
	}

	@Override
	public void modify(EmployeeModel em) throws Exception {
		sessionFactory.getCurrentSession().update(em);

	}

	@Override
	public void delete(EmployeeModel em) throws Exception {
		sessionFactory.getCurrentSession().delete(em);

	}

	@Override
	public void changePassword(String id, String password) throws Exception {
		

	}

	@Override
	public EmployeeModel getById(String id) throws Exception {
		return sessionFactory.getCurrentSession().get(EmployeeModel.class, id);
	}

	@Override
	public List<EmployeeModel> getListByAll() throws Exception {
		String hql="from EmployeeModel";
		return sessionFactory.getCurrentSession().createQuery(hql,EmployeeModel.class)
			.getResultList();
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
	public List<EmployeeModel> getListByDepartment(int departmentNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBehave(String employeeId, int behaveNo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void addBehaves(String employeeId, int[] behaveNos) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BehaveModel> getBehavesById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBehave(String employeeId, int behaveNo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBehaves(String employeeId, int[] behaveNos) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllBehaves(String employeeId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean chechHaveBehave(String employeeId, int behaveNo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EmployeeModel> getListByAgeScope(int min, int max) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> getListAndDepartment() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeModel> getListUsingLeftOuterJoinWithDepartment() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> getEmployeeNameAndDepartmentNameList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeModel> getListByGreateThanDepartmentSalaryAvg() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeModel> getListWithoutAnyBehaves() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeModel> getListBySearchCondition(String name, String sex, int minAge, int maxAge,
			Date startJoinDate, Date endJoinDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
