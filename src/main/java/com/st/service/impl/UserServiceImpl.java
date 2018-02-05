package com.st.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.UserDao;
import com.st.entity.UserEntity;
import com.st.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserEntity> find(UserEntity user) {
		// TODO Auto-generated method stub
		return userDao.find(user);
	}

	@Override
	public void save(UserEntity user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public List<UserEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return userDao.findAllPage(hql, first, max);
	}

	@Override
	public void update(UserEntity user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public void delete(UserEntity user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
	}

	@Override
	public List<UserEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return userDao.findAll(hql);
	}

}
