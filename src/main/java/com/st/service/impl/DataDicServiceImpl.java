package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.DataDicDao;
import com.st.entity.DataDicEntity;
import com.st.service.DataDicService;

@Service("dataDicService")
public class DataDicServiceImpl implements DataDicService {
	@Autowired
	private DataDicDao dataDicDao;

	@Override
	public List<DataDicEntity> find(DataDicEntity t) {
		// TODO Auto-generated method stub
		return dataDicDao.find(t);
	}

	@Override
	public void save(DataDicEntity t) {
		// TODO Auto-generated method stub
		dataDicDao.save(t);
	}

	@Override
	public List<DataDicEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return dataDicDao.findAll(hql);
	}

	@Override
	public List<DataDicEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return dataDicDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(DataDicEntity t) {
		// TODO Auto-generated method stub
		dataDicDao.update(t);
	}

	@Override
	public void delete(DataDicEntity t) {
		// TODO Auto-generated method stub
		dataDicDao.delete(t);
	}

	@Override
	public DataDicEntity get(Integer id) {
		// TODO Auto-generated method stub
		return dataDicDao.get(id);
	}

}
