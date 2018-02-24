package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.CusDevPlanDao;
import com.st.entity.CusDevPlanEntity;
import com.st.service.CusDevPlanService;

@Service("cusDevPlanService")
public class CusDevPlanServiceImpl implements CusDevPlanService {
	@Autowired
	private CusDevPlanDao cusDevPlanDao;

	@Override
	public List<CusDevPlanEntity> find(CusDevPlanEntity t) {
		// TODO Auto-generated method stub
		return cusDevPlanDao.find(t);
	}

	@Override
	public void save(CusDevPlanEntity t) {
		// TODO Auto-generated method stub
		cusDevPlanDao.save(t);
	}

	@Override
	public List<CusDevPlanEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return cusDevPlanDao.findAll(hql);
	}

	@Override
	public List<CusDevPlanEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return cusDevPlanDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(CusDevPlanEntity t) {
		// TODO Auto-generated method stub
		cusDevPlanDao.update(t);
	}

	@Override
	public void delete(CusDevPlanEntity t) {
		// TODO Auto-generated method stub
		cusDevPlanDao.delete(t);
	}

	@Override
	public CusDevPlanEntity get(Integer id) {
		// TODO Auto-generated method stub
		return cusDevPlanDao.get(id);
	}

}
