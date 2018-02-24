package com.st.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.core.dao.impl.BaseDaoImpl;
import com.st.dao.CustomerDao;
import com.st.entity.CustomerEntity;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl implements CustomerDao {

	@Override
	public List<CustomerEntity> find(CustomerEntity t) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByExample(t);
	}

	@Override
	public void save(CustomerEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return (List<CustomerEntity>) getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerEntity> findAllPage(String hql, Integer first, Integer max) {
		final String hqltemp = hql;
		return (List<CustomerEntity>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
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

	@Override
	public void update(CustomerEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(t);
	}

	@Override
	public void delete(CustomerEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public CustomerEntity get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CustomerEntity.class, id);
	}

}
