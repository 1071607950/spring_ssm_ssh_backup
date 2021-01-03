package com.city.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.city.oa.model.BehaveModel;
import com.city.oa.service.IBehaveService;
//爱好业务实现类 --- 使用纯Hibernate API完成
//@Service
public class BehaveServiceImplWithHibernate implements IBehaveService {

	@Override
	public void add(BehaveModel bm) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(BehaveModel bm) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(BehaveModel bm) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public BehaveModel getByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BehaveModel> getListByAll() throws Exception {
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
