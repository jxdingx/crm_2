package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.CusContactDao;
import com.st.entity.CusContactEntity;
import com.st.service.CusContactService;

@Service("cusContactService")
public class CusContactServiceImpl implements CusContactService {
	@Autowired
	private CusContactDao cusContactDao;

	@Override
	public List<CusContactEntity> find(CusContactEntity t) {
		// TODO Auto-generated method stub
		return cusContactDao.find(t);
	}

	@Override
	public void save(CusContactEntity t) {
		// TODO Auto-generated method stub
		cusContactDao.save(t);
	}

	@Override
	public List<CusContactEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return cusContactDao.findAll(hql);
	}

	@Override
	public List<CusContactEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return cusContactDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(CusContactEntity t) {
		// TODO Auto-generated method stub
		cusContactDao.update(t);
	}

	@Override
	public void delete(CusContactEntity t) {
		// TODO Auto-generated method stub
		cusContactDao.delete(t);
	}

	@Override
	public CusContactEntity get(Integer id) {
		// TODO Auto-generated method stub
		return cusContactDao.get(id);
	}

}
