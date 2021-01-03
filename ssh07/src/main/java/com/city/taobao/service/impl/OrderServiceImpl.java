package com.city.taobao.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.taobao.model.OrderModel;
import com.city.taobao.service.IOrderService;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private SessionFactory sessionFactory=null;
	@Override
	public List<OrderModel> getListByPriceScope(double min, double max) throws Exception {
		String hql="from OrderModel om where om.price between :min and :max";
		Query<OrderModel> query=sessionFactory.getCurrentSession().createQuery(hql,OrderModel.class);
		query.setParameter("min", min);
		query.setParameter("max", max);
		return query.getResultList(); 
	}

	@Override
	public List<OrderModel> getListByPriceWithPage(double low, double high, int rows, int page) throws Exception {
		String hql="from OrderModel om where om.price between :low and :high";
		Query<OrderModel> query=sessionFactory.getCurrentSession().createQuery(hql,OrderModel.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		query.setFirstResult(rows*(page-1));
		query.setMaxResults(rows);
		return query.getResultList(); 
	}

	@Override
	public int getCountByPrice(double low, double high) throws Exception {
		String hql="select count(om.no) from OrderModel om where om.price between :low and :high";
		Query<Long> query=sessionFactory.getCurrentSession().createQuery(hql,Long.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		return query.getSingleResult().intValue();
	}

	@Override
	public int getPageCountByPrice(double low, double high, int rows) throws Exception {
		String hql="select count(om.no) from OrderModel om where om.price between :low and :high";
		Query<Long> query=sessionFactory.getCurrentSession().createQuery(hql,Long.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		int count=query.getSingleResult().intValue();
		if(count%rows>0) {
			return count/rows+1;
		}else {
			return count/rows;
		}
	}

	@Override
	public List<OrderModel> getListBySearchCustomerName(String key) throws Exception {
		String hql="from OrderModel om where om.name like :key";
		Query<OrderModel> query=sessionFactory.getCurrentSession().createQuery(hql,OrderModel.class);
		query.setParameter("key", "%"+key+"%");
		return query.getResultList();
	}

	@Override
	public double getTotalAmountByDate(Date start, Date end) throws Exception {
		String hql="select sum(om.price*om.qty) from OrderModel om where om.date between :start and :end";
		Query<Double> query=sessionFactory.getCurrentSession().createQuery(hql,Double.class);
		query.setParameter("start", start);
		query.setParameter("end", end);
		return query.getSingleResult();
	}

}
