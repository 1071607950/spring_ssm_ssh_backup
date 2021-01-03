package com.city.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.city.oa.model.DepartmentModel;
import com.city.oa.service.IDepartmentService;
//部门业务实现类， 使用IOC的依赖注入和Hibernate API完成
//@Service("departmentServiceWithIoC")
public class DepartmentServiceImplWithDIAndHibernate implements IDepartmentService {
	//定义依赖的对象 属性变量
	
	@Autowired
	private SessionFactory sessionFactory=null; //对象类型的依赖注入
	private int age=0; //简单类型的依赖注入
	//Set注入方法
	//@Resource(name="createSessionFactoryWithFactory")
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("set注入工作...");
	}
	
	public void setAge(int age) {
		this.age = age;
		System.out.println("注入的年龄是："+age);
	}

	//默认的构造方法
	public DepartmentServiceImplWithDIAndHibernate() {
		System.out.println("默认构造方法工作...");
	}
	
	//有依赖对象的构造方法， IoC容器会调用有参数的构造方法，将SessionFactory注入到部门业务层对象
	@Autowired
	//@Inject
	public DepartmentServiceImplWithDIAndHibernate(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		System.out.println("构造方法01注入工作...");
	}
	
	public DepartmentServiceImplWithDIAndHibernate(SessionFactory sessionFactory,int age) {
		this.sessionFactory=sessionFactory;
		this.age=age;
		System.out.println("构造方法02注入工作...");
		System.out.println("注入的年龄是："+age);
	}
	

	@Override
	public void add(DepartmentModel dm) throws Exception {
		

	}

	@Override
	public void modify(DepartmentModel dm) throws Exception {
		

	}

	@Override
	public void delete(DepartmentModel dm) throws Exception {
		

	}

	@Override
	public DepartmentModel getByNo(int no) throws Exception {
		
		//int i=10/0;
		Session session=sessionFactory.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		DepartmentModel dm=session.get(DepartmentModel.class, no);
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		return dm;
		
	}

	@Override
	public List<DepartmentModel> getListByAll() throws Exception {
		
		return null;
	}

	@Override
	public List<DepartmentModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return null;
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		
		return 0;
	}

	@Override
	public DepartmentModel getByNoWithEmployees(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartmentModel> getListWithEmployees() throws Exception {
		
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
