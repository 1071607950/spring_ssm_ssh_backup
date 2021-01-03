package com.city.oa.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.city.oa.dao.IAddressDao;
import com.city.oa.dao.IContactInfoDao;
import com.city.oa.dao.IDepartmentDao;
import com.city.oa.dao.IEmployeeDao;
import com.city.oa.factory.MyBatisFactory;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IEmployeeService;

//员工业务实现类，使用MyBatis API
//@Service("employeeServiceWithMyBatis")
public class EmployeeServiceImplWithMyBatis implements IEmployeeService {

	private SqlSessionFactory ssf=null;
	
	public EmployeeServiceImplWithMyBatis() throws Exception{
		ssf=MyBatisFactory.createSqlSessionFactory();
	}
	
	@Override
	public void add(EmployeeModel em) throws Exception {
		SqlSession session=ssf.openSession();
		//推荐使用的方式
		IEmployeeDao ed=session.getMapper(IEmployeeDao.class);
		IAddressDao ad=session.getMapper(IAddressDao.class);
		IContactInfoDao cid=session.getMapper(IContactInfoDao.class);
		ed.insert(em);
		ad.insert(em.getAddress());
		cid.insert(em.getContactInfo());
		
		session.commit();
		session.close();
		
		
	}

	@Override
	public void modify(EmployeeModel em) throws Exception {
		SqlSession session=ssf.openSession();
		IEmployeeDao ed=session.getMapper(IEmployeeDao.class);
		IAddressDao ad=session.getMapper(IAddressDao.class);
		IContactInfoDao cid=session.getMapper(IContactInfoDao.class);
		ed.update(em);
		ad.update(em.getAddress());
		cid.update(em.getContactInfo());
		session.commit();
		session.close();		

	}
	//删除员工
	@Override
	public void delete(EmployeeModel em) throws Exception {
		SqlSession session=ssf.openSession();
		IEmployeeDao ed=session.getMapper(IEmployeeDao.class);
		IAddressDao ad=session.getMapper(IAddressDao.class);
		IContactInfoDao cid=session.getMapper(IContactInfoDao.class);
		ed.deleteBehaves(em.getId());  //先删除员工关联的爱好
		ad.delete(em.getAddress()); //删除员工关联的地址
		cid.delete(em.getContactInfo()); //删除员工关联的联系信息
		ed.delete(em); //最后删除员工，因为其他表有外键指向员工
		session.commit();
		session.close();	

	}

	@Override
	public EmployeeModel getById(String id) throws Exception {
		SqlSession session=ssf.openSession();
		//推荐使用的方式
		IEmployeeDao ed=session.getMapper(IEmployeeDao.class);
		EmployeeModel em=ed.selectById(id);
		
		session.commit();
		session.close();
		return em;
	}
	@Override
	public EmployeeModel getByIdWithPhoto(String id) throws Exception {
		SqlSession session=ssf.openSession();
		//推荐使用的方式
		IEmployeeDao ed=session.getMapper(IEmployeeDao.class);
		EmployeeModel em=ed.selectByIdWithPhoto(id);
		
		session.commit();
		session.close();
		return em;
	}
	
	
	//取得指定的员工，只取关联的部门对象
	public EmployeeModel getByIdWithDepartment(String id) throws Exception{
		SqlSession session=ssf.openSession();
		//推荐使用的方式
		IEmployeeDao ed=session.getMapper(IEmployeeDao.class);
		EmployeeModel em=ed.selectByIdWithDepartment(id);
		
		session.commit();
		session.close();
		return em;
		
	}
	//取得指定的员工，取关联的部门,地址，联系信息，爱好等关联对象
	public EmployeeModel getByIdWithDepartmentAddressContactInfoBehaves(String id) throws Exception{
		
		SqlSession session=ssf.openSession();
		//推荐使用的方式
		IEmployeeDao ed=session.getMapper(IEmployeeDao.class);
		EmployeeModel em=ed.selectByIdWithDepartmentAndAddressAndContactInfoAndBehaves(id);
		
		session.commit();
		session.close();
		return em;
	}

	@Override
	public List<EmployeeModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeModel> getListByAllWithDepartment() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeModel> getListBySearchCondition(String name, String sex, int minAge, int maxAge,
			Date startJoinDate, Date endJoinDate) throws Exception {
		
		SqlSession session=ssf.openSession();
		//推荐使用的方式
		IEmployeeDao ed=session.getMapper(IEmployeeDao.class);
		List<EmployeeModel> list=ed.selectListBySearchCondition(name, sex, minAge, maxAge, startJoinDate, endJoinDate);
		session.commit();
		session.close();
		
		return list;
	}
	//==================员工爱好管理=========================================================
	//增加员工爱好，单个
	@Override
	public void addBehave(String id, int behaveNo) throws Exception {
		SqlSession session=ssf.openSession();
		//推荐使用的方式
		IEmployeeDao ed=session.getMapper(IEmployeeDao.class);
		ed.insertBehave(id, behaveNo);
		
		session.commit();
		session.close();
		

	}
	//增加员工爱好，多个
	@Override
	public void addBehaves(String id, int[] behaveNos) throws Exception {
		SqlSession session=ssf.openSession();
		//推荐使用的方式
		IEmployeeDao ed=session.getMapper(IEmployeeDao.class);
		ed.insertBehaves(id, behaveNos);
		session.commit();
		session.close();
	}
	//取得有指定多个爱好的员工列表，爱好通过数组参数确定
	public List<EmployeeModel> getListByBehaves(int[] behaves) throws Exception{
		SqlSession session=ssf.openSession();
		//推荐使用的方式
		IEmployeeDao ed=session.getMapper(IEmployeeDao.class);
		List<EmployeeModel> list=ed.selectListByBehaves(behaves);
		session.commit();
		session.close();
		return list;
		
	}

}
