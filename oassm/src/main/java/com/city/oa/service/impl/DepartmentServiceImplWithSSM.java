package com.city.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.oa.dao.IDepartmentDao;
import com.city.oa.model.DepartmentModel;
import com.city.oa.service.IDepartmentService;
//使用Spring集成MyBatis方式实现业务实现类
@Service("DepartmentServiceWithSSM")
@Transactional
public class DepartmentServiceImplWithSSM implements IDepartmentService {
	
	@Autowired
	private IDepartmentDao departmentDao=null;

	@Override
	@Transactional
	public int add(DepartmentModel dm) throws Exception {
		
		departmentDao.insert(dm);
		return dm.getNo();
		
	}

	@Override
	@Transactional
	public void modify(DepartmentModel dm) throws Exception {
		departmentDao.update(dm);

	}

	@Override
	public void delete(DepartmentModel dm) throws Exception {
		departmentDao.delete(dm);

	}
	
	@Override
	@Transactional(readOnly=true)
	public DepartmentModel getByNoWithoutEmployees(int no) throws Exception {
		
		return departmentDao.selectByNo(no);
	}

	@Override
	@Transactional(readOnly=true)
	public DepartmentModel getByNoWithEmployees(int no) throws Exception {
		
		return departmentDao.selectByNoWithEmployess(no);
	}
	

	@Override
	@Transactional(readOnly=true)
	public List<DepartmentModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return departmentDao.selectListByAllWithPage(rows*(page-1), rows) ;
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepartmentModel> getListByAll() throws Exception {
		
		return departmentDao.selectListByAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepartmentModel> getListByAllWithEmployees() throws Exception {
		
		return null;
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return departmentDao.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	

}
