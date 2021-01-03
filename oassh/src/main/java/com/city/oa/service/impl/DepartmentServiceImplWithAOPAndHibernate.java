package com.city.oa.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.city.oa.model.DepartmentModel;
import com.city.oa.service.IDepartmentService;


//@Service("departmentServiceWithAOP")
public class DepartmentServiceImplWithAOPAndHibernate implements IDepartmentService {

	private Session session=null; 
	//让事务Advice传入Session对象
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void add(DepartmentModel dm) throws Exception {
		session.save(dm);

	}

	@Override
	public void modify(DepartmentModel dm) throws Exception {
		session.update(dm);


	}

	@Override
	public void delete(DepartmentModel dm) throws Exception {
		session.delete(dm);


	}

	@Override
	public DepartmentModel getByNo(int no) throws Exception {
		
		return session.get(DepartmentModel.class, no);
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
