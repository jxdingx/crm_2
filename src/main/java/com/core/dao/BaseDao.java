package com.core.dao;

import java.util.List;

public interface BaseDao<T> {
	List<T> find(T t);

	void save(T t);

	List<T> findAll(String hql);

	List<T> findAllPage(String hql, Integer first, Integer max);

	void update(T t);

	void delete(T t);

	T get(Integer id);
}
