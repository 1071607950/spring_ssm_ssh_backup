package com.city.oa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.oa.dao.IDepartmentDao;
import com.city.oa.dao.IEmployeeDao;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IEmployeeService;

//使用Spring集成MyBatis方式的员工业务实现类

@Service("employeeServiceWithSSM")
@Transactional
public class EmployeeServiceImplWithSSM implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao employeeDao=null;
	@Autowired
	private IDepartmentDao departmentDao=null;
	

	@Override
	public void add(EmployeeModel em) throws Exception {
		if(em.getPhotoContentType()!=null) {
			employeeDao.insertWithPhoto(em);
		}
		else {
			employeeDao.insert(em);
		}
		

	}

	@Override
	public void modify(EmployeeModel em) throws Exception {
		employeeDao.update(em);

	}

	@Override
	public void delete(EmployeeModel em) throws Exception {
		employeeDao.delete(em);
	}

	@Override
	public EmployeeModel getById(String id) throws Exception {
		
		return employeeDao.selectById(id);
	}
	public EmployeeModel getByIdWithPhoto(String id) throws Exception{
		return employeeDao.selectByIdWithPhoto(id);
	}

	@Override
	public EmployeeModel getByIdWithDepartment(String id) throws Exception {
		
		return null;
	}

	@Override
	public EmployeeModel getByIdWithDepartmentAddressContactInfoBehaves(String id) throws Exception {
		
		return null;
	}

	@Override
	public List<EmployeeModel> getListByAll() throws Exception {
		return employeeDao.selectListByAll();
	}

	@Override
	public List<EmployeeModel> getListByAllWithDepartment() throws Exception {
		
		return employeeDao.selectListByAllWithDepartment();
	}

	@Override
	public List<EmployeeModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeModel> getListBySearchCondition(String name, String sex, int minAge, int maxAge,
			Date startJoinDate, Date endJoinDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBehave(String id, int behaveNo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void addBehaves(String id, int[] behaveNos) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeeModel> getListByBehaves(int[] behaves) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
