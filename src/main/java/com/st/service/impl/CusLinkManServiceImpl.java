package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.CusLinkManDao;
import com.st.entity.CusLinkManEntity;
import com.st.service.CusLinkManService;

@Service("cusLinkManService")
public class CusLinkManServiceImpl implements CusLinkManService {

	@Autowired
	private CusLinkManDao cusLinkManDao;

	@Override
	public List<CusLinkManEntity> find(CusLinkManEntity t) {
		// TODO Auto-generated method stub
		return cusLinkManDao.find(t);
	}

	@Override
	public void save(CusLinkManEntity t) {
		// TODO Auto-generated method stub
		cusLinkManDao.save(t);
	}

	@Override
	public List<CusLinkManEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return cusLinkManDao.findAll(hql);
	}

	@Override
	public List<CusLinkManEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return cusLinkManDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(CusLinkManEntity t) {
		// TODO Auto-generated method stub
		cusLinkManDao.update(t);
	}

	@Override
	public void delete(CusLinkManEntity t) {
		// TODO Auto-generated method stub
		cusLinkManDao.delete(t);
	}

	@Override
	public CusLinkManEntity get(Integer id) {
		// TODO Auto-generated method stub
		return cusLinkManDao.get(id);
	}

}
