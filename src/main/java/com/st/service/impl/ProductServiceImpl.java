package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.ProductDao;
import com.st.entity.ProductEntity;
import com.st.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductEntity> find(ProductEntity t) {
		// TODO Auto-generated method stub
		return productDao.find(t);
	}

	@Override
	public void save(ProductEntity t) {
		// TODO Auto-generated method stub
		productDao.save(t);
	}

	@Override
	public List<ProductEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return productDao.findAll(hql);
	}

	@Override
	public List<ProductEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return productDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(ProductEntity t) {
		// TODO Auto-generated method stub
		productDao.update(t);
	}

	@Override
	public void delete(ProductEntity t) {
		// TODO Auto-generated method stub
		productDao.delete(t);
	}

	@Override
	public ProductEntity get(Integer id) {
		// TODO Auto-generated method stub
		return productDao.get(id);
	}

}
