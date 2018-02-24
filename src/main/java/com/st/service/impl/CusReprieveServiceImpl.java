package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.CusReprieveDao;
import com.st.entity.CusReprieveEntity;
import com.st.service.CusReprieveService;

@Service("cusReprieveService")
public class CusReprieveServiceImpl implements CusReprieveService {

	@Autowired
	private CusReprieveDao cusReprieveDao;

	@Override
	public List<CusReprieveEntity> find(CusReprieveEntity t) {
		// TODO Auto-generated method stub
		return cusReprieveDao.find(t);
	}

	@Override
	public void save(CusReprieveEntity t) {
		// TODO Auto-generated method stub
		cusReprieveDao.save(t);
	}

	@Override
	public List<CusReprieveEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return cusReprieveDao.findAll(hql);
	}

	@Override
	public List<CusReprieveEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return cusReprieveDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(CusReprieveEntity t) {
		// TODO Auto-generated method stub
		cusReprieveDao.update(t);
	}

	@Override
	public void delete(CusReprieveEntity t) {
		// TODO Auto-generated method stub
		cusReprieveDao.delete(t);
	}

	@Override
	public CusReprieveEntity get(Integer id) {
		// TODO Auto-generated method stub
		return cusReprieveDao.get(id);
	}

}
