package com.city.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.oa.dao.IBehaveDao;
import com.city.oa.model.BehaveModel;
import com.city.oa.service.IBehaveService;
//爱好实现类，使用Spring集成MyBatis模式
@Service
@Transactional
public class BehaveServiceImplWithSSM implements IBehaveService {
	@Autowired
	private IBehaveDao behaveDao=null;
	@Override
	public int add(BehaveModel dm) throws Exception {
		
		return 0;
	}

	@Override
	public void modify(BehaveModel dm) throws Exception {
		

	}

	@Override
	public void delete(BehaveModel dm) throws Exception {
		

	}

	@Override
	public BehaveModel getByNo(int no) throws Exception {
		
		return null;
	}

	@Override
	public List<BehaveModel> getListByAll() throws Exception {
		
		return null;
	}

	@Override
	public List<BehaveModel> getListByAllWithEmployees() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BehaveModel> getListByAllWithPage(int rows, int page) throws Exception {
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

}
