package com.st.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.core.dao.impl.BaseDaoImpl;
import com.st.dao.UserDao;
import com.st.entity.UserEntity;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	public List<UserEntity> find(UserEntity user) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByExample(user);
	}

	public void save(UserEntity user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		final String hqltemp = hql;
		return (List<UserEntity>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query<?> query = session.createQuery(hqltemp);
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();
			}

		});
	}

	@SuppressWarnings("unchecked")
	public List<UserEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return (List<UserEntity>) getHibernateTemplate().find(hql);
	}

	@Override
	public void update(UserEntity user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(user);
	}

	@Override
	public void delete(UserEntity user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(user);
	}

}
