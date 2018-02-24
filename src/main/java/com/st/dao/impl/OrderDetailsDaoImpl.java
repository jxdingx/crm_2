package com.st.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.core.dao.impl.BaseDaoImpl;
import com.st.dao.OrderDetailsDao;
import com.st.entity.OrderDetailsEntity;
@Repository
public class OrderDetailsDaoImpl extends BaseDaoImpl implements OrderDetailsDao {

	@Override
	public List<OrderDetailsEntity> find(OrderDetailsEntity t) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByExample(t);
	}

	@Override
	public void save(OrderDetailsEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetailsEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return (List<OrderDetailsEntity>) getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetailsEntity> findAllPage(String hql, Integer first, Integer max) {
		final String hqltemp = hql;
		return (List<OrderDetailsEntity>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
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
	public void update(OrderDetailsEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(OrderDetailsEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public OrderDetailsEntity get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(OrderDetailsEntity.class, id);
	}

}
