package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.SaleChanceDao;
import com.st.entity.SaleChanceEntity;
import com.st.service.SaleChanceService;

@Service("saleChanceService")
public class SaleChanceServiceImpl implements SaleChanceService {
	@Autowired
	private SaleChanceDao saleChanceDao;

	@Override
	public List<SaleChanceEntity> find(SaleChanceEntity t) {
		// TODO Auto-generated method stub
		return saleChanceDao.find(t);
	}

	@Override
	public void save(SaleChanceEntity t) {
		// TODO Auto-generated method stub
		saleChanceDao.save(t);
	}

	@Override
	public List<SaleChanceEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return saleChanceDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(SaleChanceEntity t) {
		// TODO Auto-generated method stub
		saleChanceDao.update(t);
	}

	@Override
	public void delete(SaleChanceEntity t) {
		// TODO Auto-generated method stub
		saleChanceDao.delete(t);
	}

	@Override
	public List<SaleChanceEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return saleChanceDao.findAll(hql);
	}

	@Override
	public SaleChanceEntity get(Integer id) {
		// TODO Auto-generated method stub
		return saleChanceDao.get(id);
	}

}
