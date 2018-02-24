package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.OrderDetailsDao;
import com.st.entity.OrderDetailsEntity;
import com.st.service.OrderDetailsService;

@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	private OrderDetailsDao orderDetailsDao;

	@Override
	public List<OrderDetailsEntity> find(OrderDetailsEntity t) {
		// TODO Auto-generated method stub
		return orderDetailsDao.find(t);
	}

	@Override
	public void save(OrderDetailsEntity t) {
		// TODO Auto-generated method stub
		orderDetailsDao.save(t);
	}

	@Override
	public List<OrderDetailsEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return orderDetailsDao.findAll(hql);
	}

	@Override
	public List<OrderDetailsEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return orderDetailsDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(OrderDetailsEntity t) {
		// TODO Auto-generated method stub
		orderDetailsDao.update(t);
	}

	@Override
	public void delete(OrderDetailsEntity t) {
		// TODO Auto-generated method stub
		orderDetailsDao.delete(t);
	}

	@Override
	public OrderDetailsEntity get(Integer id) {
		// TODO Auto-generated method stub
		return orderDetailsDao.get(id);
	}

}
