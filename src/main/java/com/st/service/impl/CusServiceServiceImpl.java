package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.CusServiceDao;
import com.st.entity.CusServiceEntity;
import com.st.service.CusServiceService;

@Service("cusServiceService")
public class CusServiceServiceImpl implements CusServiceService {

	@Autowired
	private CusServiceDao cusServiceDao;

	@Override
	public List<CusServiceEntity> find(CusServiceEntity t) {
		// TODO Auto-generated method stub
		return cusServiceDao.find(t);
	}

	@Override
	public void save(CusServiceEntity t) {
		// TODO Auto-generated method stub
		cusServiceDao.save(t);
	}

	@Override
	public List<CusServiceEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return cusServiceDao.findAll(hql);
	}

	@Override
	public List<CusServiceEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return cusServiceDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(CusServiceEntity t) {
		// TODO Auto-generated method stub
		cusServiceDao.update(t);
	}

	@Override
	public void delete(CusServiceEntity t) {
		// TODO Auto-generated method stub
		cusServiceDao.delete(t);
	}

	@Override
	public CusServiceEntity get(Integer id) {
		// TODO Auto-generated method stub
		return cusServiceDao.get(id);
	}

}
