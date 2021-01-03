package com.city.oa.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.city.oa.factory.HibernateFactory;
import com.city.oa.model.DepartmentModel;
import com.city.oa.service.IDepartmentService;
//部门的业务实现类（使用单独的Hibernate API实现）

//@Service("departmentService")
public class DepartmentServiceImplWithHibernate implements IDepartmentService {
	private SessionFactory sf=null;
	@PostConstruct
	public void init() throws Exception {
		sf=HibernateFactory.createSessionFactory();
		System.out.println("部门业务层初始化方法");
	}
	
	@PreDestroy
	public void cleanup() throws Exception {
		System.out.println("部门业务层销毁方法");
	}
	
	@Override
	public void add(DepartmentModel dm) throws Exception {
		//使用Hibernate API完成增加功能
		//创建配置类对象
		//Configuration cfg=new Configuration();
		//读取hibernate.cfg.xml配置文件
		//cfg.configure();
		//读取其他XML配置文件
		//cfg.configure("config/lhd.cfg.xml");
		//cfg.addClass(DepartmentModel.class);
		//创建SessionFactory对象
		//SessionFactory sf=cfg.buildSessionFactory();
		
		
		//dm处于临时态
		
		//SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		
		
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.save(dm); //转换为持久态
		//处于持久态的对象，可以直接修改属性，Hibernate自动完成与表记录同步
		//dm.setCode("YYYY");
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//dm还在JVM中，表中有对应记录，session已经关闭了，dm处于游离态
		//dm.setCode("ZZZZ"); //关闭session后再修改属性，不会更新到数据库表中，因为是游离态了。
		
		
	}
	@Override
	public void modify(DepartmentModel dm) throws Exception{
		//SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.update(dm);
		//提交事务
		tx.commit();
		//关闭session
		session.close();
	}
	@Override
	public void delete(DepartmentModel dm) throws Exception{
		
		//SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		session.delete(dm); 
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//删除后处于删除状态
		
		
	}
	
	

	@Override
	public DepartmentModel getByNo(int no) throws Exception {
		//SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//完成Model对象增加到记录到表中
		DepartmentModel dm=session.get(DepartmentModel.class, no);
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//int m=10/0;
		return dm;
	}
	//取得所有部门的列表
	@Override
	public List<DepartmentModel> getListByAll() throws Exception {
		
		//SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//定义HQL查询语句
		String hql="from DepartmentModel dm";
		//创建运行HQL的Query接口对象
		Query<DepartmentModel> query=session.createQuery(hql,DepartmentModel.class);
		//调用Query接口的查询方法，取得查询的Model对象集合
		List<DepartmentModel> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		
		return list;
	}
	//取得所有部门列表的方法，分页模式。
	// 参数：rows: 每页显示的个数， page：要取得的第几页的对象
	@Override
	public List<DepartmentModel> getListByAllWithPage(int rows, int page) throws Exception {
		//创建SessionFactory对象
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//定义HQL查询语句
		String hql="from DepartmentModel";
		//创建运行HQL的Query接口对象
		Query<DepartmentModel> query=session.createQuery(hql,DepartmentModel.class);
		//设置检索对象的开始位置
		query.setFirstResult(rows*(page-1));
		//设置检索的对象的个数
		query.setMaxResults(rows);
		//调用Query接口的查询方法，取得查询的Model对象集合
		List<DepartmentModel> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		
		return list;
	}
	//取得所有部门的个数
	@Override
	public int getCountByAll() throws Exception {
		int count=0;
		//取得SessionFactory
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//取得部门个数的HQL语句
		String hql="select count(dm.id) from DepartmentModel dm";
		//创建执行HQL的Query接口对象
		Query<Long> query=session.createQuery(hql,Long.class);
		//
		Long ocount=query.getSingleResult();
		if(ocount!=null) {
			count=ocount.intValue();
		}
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		return count;
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//=====================HQL内关联关联查询方法====================================
	//取得指定的部门，并取得其关联的员工集合
	public DepartmentModel getByNoWithEmployees(int no) throws Exception{
		
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		
		String hql="from DepartmentModel dm inner join fetch dm.employees where dm.no=:no";
		
		Query<DepartmentModel> query=session.createQuery(hql,DepartmentModel.class);
		query.setParameter("no", no);
		DepartmentModel dm=query.getSingleResult();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		return dm;
	}
	//取得部门列表，并立即取得每个部门关联的员工集合
	public List<DepartmentModel> getListWithEmployees() throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		
		String hql="select distinct dm from DepartmentModel dm inner join fetch dm.employees";
		
		Query<DepartmentModel> query=session.createQuery(hql,DepartmentModel.class);
		
		List<DepartmentModel> list=query.getResultList();
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		
		return list;
		
	}
	
	//=====================HQL外关联查询方法====================================
	//取得所有部门和关联的员工对象，关联员工对象可以没有,使用普通外关联查询
	public List<Object[]> getListAndEmployee() throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//查询所有部门和关联的员工，使用左外关联查询，即取所有的部门，如果没有关联员工对象，员工为null
		String hql="from DepartmentModel dm left outer  join  dm.employees em";
		//创建执行HQL的Query对象
		Query<Object[]> query=session.createQuery(hql,Object[].class);
		//执行HQL
		List<Object[]> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		return list;
		
	}
		
	//查询所有部门列表，并取得每个部门关联的员工集合（没有关联的员工也要查询出来）。 抓取外关联查询
	public List<DepartmentModel> getListWithOrWithoutEmployees() throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//查询所有部门，并抓取其关联的员工，使用抓取左外关联查询，即取所有的部门，并立即检索部门的员工集合属性
		String hql="select distinct dm from DepartmentModel dm left outer join fetch  dm.employees";
		//创建执行HQL的Query对象
		Query<DepartmentModel> query=session.createQuery(hql,DepartmentModel.class);
		//执行HQL
		List<DepartmentModel> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		return list;
		
	}
	
	
	//=====================HQL分类汇总查询=====================================
	
	
	//取得每个部门的汇总工资,并且部门平均工资在low和high之间 （having子句案例）
	public List<Object[]> getDepartmentAndTotalSalary(double avgLow, double avgHigh) throws Exception{
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//有having子句的分类汇总HQL语句，
		String hql="select em.department, sum(em.salary) from EmployeeModel em group by em.department having avg(em.salary) between :low and :high";
		//创建执行HQL的Query对象
		Query<Object[]> query=session.createQuery(hql,Object[].class);
		//设置HQL的命名参数
		query.setParameter("low", avgLow);
		query.setParameter("high", avgHigh);
		//执行HQL，取得查询结果
		List<Object[]> list=query.getResultList();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//返回查询结果
		return list;
	}
		
		
		
	//=====================子查询测试方法======================================
	//取得所有部门中平均工资最高的平均工资
	public double getMaxAvgSalaryOfDepartment() throws Exception{
		double result=0;
		SessionFactory sf=HibernateFactory.createSessionFactory();
		//创建Session
		Session session=sf.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//有having子句的分类汇总HQL语句，
		String hql="select avg(em.salary) from EmployeeModel em group by em.department having avg(em.salary)>=all(select avg(emm.salary) from EmployeeModel emm group by emm.department ) ";
		//创建执行HQL的Query对象
		Query<Double> query=session.createQuery(hql,Double.class);
		
		//执行HQL，取得查询结果
		result=query.getSingleResult();
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//返回查询结果
		
		return result;
	}
		
	
	

}
