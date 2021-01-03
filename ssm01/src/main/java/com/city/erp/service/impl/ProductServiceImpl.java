package com.city.erp.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.city.erp.dao.IProductDao;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;
//部门业务实现类,使用MyBatis API完成
@Service("ProductService")
public class ProductServiceImpl implements IProductService{

	private SqlSessionFactory sqlSessionFactory=null;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void add(ProductModel pm) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		IProductDao pd=session.getMapper(IProductDao.class);
		pd.insert(pm);
		session.commit();
		session.close();
	}

	@Override
	public void modify(ProductModel pm) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		IProductDao pd=session.getMapper(IProductDao.class);
		pd.update(pm);
		session.commit();
		session.close();
	}

	@Override
	public void delete(ProductModel pm) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		IProductDao pd=session.getMapper(IProductDao.class);
		pd.delete(pm);
		session.commit();
		session.close();
	}

	@Override
	public ProductModel getByNo(int no) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		IProductDao pd=session.getMapper(IProductDao.class);
		ProductModel pm=pd.selectById(no);
		session.commit();
		session.close();
		return pm;
	}

	@Override
	public List<ProductModel> getListByAll() throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		IProductDao pd=session.getMapper(IProductDao.class);
		List<ProductModel> list=pd.selectListByAll();
		session.commit();
		session.close();
		return list;
	}
	
}
