package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.CusLossDao;
import com.st.entity.CusLossEntity;
import com.st.service.CusLossService;

@Service("cusLossService")
public class CusLossServiceImpl implements CusLossService {

	@Autowired
	private CusLossDao cusLossDao;

	@Override
	public List<CusLossEntity> find(CusLossEntity t) {
		// TODO Auto-generated method stub
		return cusLossDao.find(t);
	}

	@Override
	public void save(CusLossEntity t) {
		// TODO Auto-generated method stub
		cusLossDao.save(t);
	}

	@Override
	public List<CusLossEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return cusLossDao.findAll(hql);
	}

	@Override
	public List<CusLossEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return cusLossDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(CusLossEntity t) {
		// TODO Auto-generated method stub
		cusLossDao.update(t);
	}

	@Override
	public void delete(CusLossEntity t) {
		// TODO Auto-generated method stub
		cusLossDao.delete(t);
	}

	@Override
	public CusLossEntity get(Integer id) {
		// TODO Auto-generated method stub
		return cusLossDao.get(id);
	}

}
