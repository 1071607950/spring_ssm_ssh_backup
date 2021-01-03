package com.city.oa.service.impl;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.city.oa.dao.IDepartmentDao;
import com.city.oa.factory.MyBatisFactory;
import com.city.oa.model.DepartmentModel;
import com.city.oa.service.IDepartmentService;
//部门业务实现类，使用MyBatis API完成
//@Service("departmentServiceWithMyBatis")
public class DepartmentServiceImplWithMyBatis implements IDepartmentService {

	@Override
	public int add(DepartmentModel dm) throws Exception {
		SqlSessionFactory ssf=MyBatisFactory.createSqlSessionFactory();
		SqlSession session=ssf.openSession();
		//推荐使用的方式
		IDepartmentDao dd=session.getMapper(IDepartmentDao.class);
		dd.insert(dm);
		//不推荐的方式
		//session.insert("com.city.oa.dao.IDepartmentDao.insert",dm);
		session.commit();
		session.close();
		return dm.getNo();
	}

	@Override
	public void modify(DepartmentModel dm) throws Exception {
		
		Properties pros=new Properties();
		pros.setProperty("username", "cityoa");
		pros.setProperty("password", "cityoa");
		
		SqlSessionFactory ssf=MyBatisFactory.createSqlSessionFactory(pros);
		
		SqlSession session=ssf.openSession();
		//session.update("com.city.oa.dao.IDepartmentDao.update",dm);
		IDepartmentDao dd=session.getMapper(IDepartmentDao.class);
		dd.update(dm);
		
		session.commit();
		session.close();

	}

	@Override
	public void delete(DepartmentModel dm) throws Exception {
		SqlSessionFactory ssf=MyBatisFactory.createSqlSessionFactory();
		SqlSession session=ssf.openSession();
		IDepartmentDao dd=session.getMapper(IDepartmentDao.class);
		dd.delete(dm);
		session.commit();
		session.close();

	}
	
	//取得指定的部门对象，不取关联的员工集合
	public DepartmentModel getByNoWithoutEmployees(int no) throws Exception{
		SqlSessionFactory ssf=MyBatisFactory.createSqlSessionFactory();
		SqlSession session=ssf.openSession();
		IDepartmentDao dd=session.getMapper(IDepartmentDao.class);
		DepartmentModel dm=dd.selectByNo(no);
		session.commit();
		session.close();
		return dm;
		
	}
	//取得指定的部门对象，同时取关联的员工集合
	public DepartmentModel getByNoWithEmployees(int no) throws Exception
	{
		SqlSessionFactory ssf=MyBatisFactory.createSqlSessionFactory();
		SqlSession session=ssf.openSession();
		IDepartmentDao dd=session.getMapper(IDepartmentDao.class);
		DepartmentModel dm=dd.selectByNoWithEmployess(no);
		session.commit();
		session.close();
		return dm;
	}

	@Override
	public List<DepartmentModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		SqlSessionFactory ssf=MyBatisFactory.createSqlSessionFactory();
		SqlSession session=ssf.openSession();
		IDepartmentDao dd=session.getMapper(IDepartmentDao.class);
		List<DepartmentModel> list=dd.selectListByAllWithPage(rows*(page-1), rows);
		session.commit();
		session.close();
		
		return list;
	}

	@Override
	public List<DepartmentModel> getListByAll() throws Exception {
		SqlSessionFactory ssf=MyBatisFactory.createSqlSessionFactory();
		SqlSession session=ssf.openSession();
		IDepartmentDao dd=session.getMapper(IDepartmentDao.class);
		List<DepartmentModel> list=dd.selectListByAll();
		session.commit();
		session.close();
		
		return list;
		
	}

	@Override
	public List<DepartmentModel> getListByAllWithEmployees() throws Exception {
		SqlSessionFactory ssf=MyBatisFactory.createSqlSessionFactory();
		SqlSession session=ssf.openSession();
		IDepartmentDao dd=session.getMapper(IDepartmentDao.class);
		List<DepartmentModel> list=dd.selectListByAllWithEmployees();
		session.commit();
		session.close();
		
		return list;
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
