package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.CustomerDao;
import com.st.entity.CustomerEntity;
import com.st.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<CustomerEntity> find(CustomerEntity t) {
		// TODO Auto-generated method stub
		return customerDao.find(t);
	}

	@Override
	public void save(CustomerEntity t) {
		// TODO Auto-generated method stub
		customerDao.save(t);
	}

	@Override
	public List<CustomerEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return customerDao.findAll(hql);
	}

	@Override
	public List<CustomerEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return customerDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(CustomerEntity t) {
		// TODO Auto-generated method stub
		customerDao.update(t);
	}

	@Override
	public void delete(CustomerEntity t) {
		// TODO Auto-generated method stub
		customerDao.delete(t);
	}

	@Override
	public CustomerEntity get(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.get(id);
	}

}
