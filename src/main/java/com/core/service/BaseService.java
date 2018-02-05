package com.core.service;

import java.util.List;

public interface BaseService<T> {

	List<T> find(T t);

	void save(T t);

	List<T> findAll(String hql);

	List<T> findAllPage(String hql, Integer first, Integer max);

	void update(T t);

	void delete(T t);
}
