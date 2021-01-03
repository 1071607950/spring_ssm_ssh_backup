package com.city.sales.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.city.sales.dao.IOrderDao;
import com.city.sales.model.OrderModel;
import com.city.sales.service.IOrderService;

//订单业务实现类,使用MyBatis API完成
public class OrderServiceImpl implements IOrderService{

	private SqlSessionFactory sqlSessionFactory=null;

	public OrderServiceImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void add(OrderModel em) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		IOrderDao od=session.getMapper(IOrderDao.class);
		od.insert(em);
		session.commit();
		session.close();
	}

	@Override
	public List<OrderModel> getListBySearchName(String keyword) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		IOrderDao od=session.getMapper(IOrderDao.class);
		List<OrderModel> list=od.selectListBySearchName(keyword);
		session.commit();
		session.close();
		return list;
	}

	@Override
	public double getAmountByDateScope(Date start, Date end) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		IOrderDao od=session.getMapper(IOrderDao.class);
		double result=od.selectAmountByDateScope(start, end);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public List<OrderModel> getListByPriceScope(double low, double high) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		IOrderDao od=session.getMapper(IOrderDao.class);
		List<OrderModel> list=od.selectListByPriceScope(low, high);
		session.commit();
		session.close();
		return list;
	}

	@Override
	public double getCountByPriceScope(double low, double hight) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		IOrderDao od=session.getMapper(IOrderDao.class);
		double result=od.selectCountByPriceScope(low, hight);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public double getAmountByProduct(String productName) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		IOrderDao od=session.getMapper(IOrderDao.class);
		double result=od.selectAmountByProduct(productName);
		session.commit();
		session.close();
		return result;
	}

	
}
