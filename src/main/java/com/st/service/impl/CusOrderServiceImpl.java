package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.CusOrderDao;
import com.st.entity.CusOrderEntity;
import com.st.service.CusOrderService;

@Service("cusOrderService")
public class CusOrderServiceImpl implements CusOrderService {
	@Autowired
	private CusOrderDao cusOrderDao;

	@Override
	public List<CusOrderEntity> find(CusOrderEntity t) {
		// TODO Auto-generated method stub
		return cusOrderDao.find(t);
	}

	@Override
	public void save(CusOrderEntity t) {
		// TODO Auto-generated method stub
		cusOrderDao.save(t);
	}

	@Override
	public List<CusOrderEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return cusOrderDao.findAll(hql);
	}

	@Override
	public List<CusOrderEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return cusOrderDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(CusOrderEntity t) {
		// TODO Auto-generated method stub
		cusOrderDao.update(t);
	}

	@Override
	public void delete(CusOrderEntity t) {
		// TODO Auto-generated method stub
		cusOrderDao.delete(t);
	}

	@Override
	public CusOrderEntity get(Integer id) {
		// TODO Auto-generated method stub
		return cusOrderDao.get(id);
	}

}
