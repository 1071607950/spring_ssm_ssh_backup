package com.city.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.erp.model.CategoryModel;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {
	@Autowired
	private SessionFactory sessionFactory=null;
	@Override
	public void add(int categoryNo, String name, double price, int qty) throws Exception {
		ProductModel pm=new ProductModel();
		pm.setName(name);
		pm.setPrice(price);
		pm.setQty(qty);
		CategoryModel cm=sessionFactory.getCurrentSession().get(CategoryModel.class, categoryNo);
		if(cm!=null) {
			pm.setCategory(cm);
			sessionFactory.getCurrentSession().save(pm);
		}else {
			System.out.println("指定的产品类别不存在");
		}
	}

	@Override
	public void modify(int no, String name, int categoryNo, double price, int qty) throws Exception {
		ProductModel pm=sessionFactory.getCurrentSession().get(ProductModel.class, no);
		if(pm!=null) {
			pm.setName(name);
			pm.setCategory(sessionFactory.getCurrentSession().get(CategoryModel.class, categoryNo));
			pm.setPrice(price);
			pm.setQty(qty);
			sessionFactory.getCurrentSession().update(pm);
		}else {
			System.out.println("指定的产品编号不存在");
		}
	}

	@Override
	public void changePrice(int productNo, double price) throws Exception {
		ProductModel pm=sessionFactory.getCurrentSession().get(ProductModel.class, productNo);
		if(pm!=null) {
			pm.setPrice(price);
			sessionFactory.getCurrentSession().update(pm);
		}else {
			System.out.println("指定的产品编号不存在");
		}
	}

	@Override
	public double getPriceByProduct(int productNo) throws Exception {
		ProductModel pm=sessionFactory.getCurrentSession().get(ProductModel.class, productNo);
		if(pm!=null) {
			return pm.getPrice();
		}else {
			return 0;
		}
	}

	@Override
	public void delete(int no) throws Exception {
		ProductModel pm=sessionFactory.getCurrentSession().get(ProductModel.class, no);
		sessionFactory.getCurrentSession().delete(pm);
	}

	@Override
	public ProductModel getProduct(int no) throws Exception {
		return sessionFactory.getCurrentSession().get(ProductModel.class, no);
	}

	@Override
	public double getAmontByProduct(int productNo) throws Exception {
		ProductModel pm=sessionFactory.getCurrentSession().get(ProductModel.class, productNo);
		if(pm!=null) {
			return pm.getPrice()*pm.getQty();
		}else {
			return 0;
		}
	}

	@Override
	public int getTotalQTYByCategory(int categoryNo) throws Exception {
		CategoryModel cm=sessionFactory.getCurrentSession().get(CategoryModel.class, categoryNo);
		int result=0;
		if(cm!=null) {
			List<ProductModel> lists=new ArrayList<ProductModel>(cm.getProducts()); 
			for(ProductModel list:lists) {
				result+=list.getQty();
			}
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public boolean checkProductInCategory(int productNo, int categoryNo) throws Exception {
		ProductModel pm=sessionFactory.getCurrentSession().get(ProductModel.class, productNo);
		CategoryModel cm=sessionFactory.getCurrentSession().get(CategoryModel.class, categoryNo);
		if(pm!=null && cm!=null) {
			return cm.getProducts().contains(pm);
		}else {
			System.out.println("指定的类别或产品不存在");
			return false;
		}
		
	}

}
