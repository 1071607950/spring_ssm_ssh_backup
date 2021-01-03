package com.city.oa.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.oa.model.BehaveModel;
import com.city.oa.service.IBehaveService;
//爱好业务实现类---- 使用Spring集成Hibernate完成
@Service
@Transactional
public class BehaveServiceImplWithSSH implements IBehaveService {

	@Autowired
	private SessionFactory sessionFactory=null;
	
	@Override
	public void add(BehaveModel bm) throws Exception {
		

	}

	@Override
	public void modify(BehaveModel bm) throws Exception {
		

	}

	@Override
	public void delete(BehaveModel bm) throws Exception {
		

	}

	@Override
	public BehaveModel getByNo(int no) throws Exception {
		
		return null;
	}

	@Override
	public List<BehaveModel> getListByAll() throws Exception {
		
		String hql="from BehaveModel";
		return sessionFactory.getCurrentSession()
			.createQuery(hql,BehaveModel.class)
			.getResultList();
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
