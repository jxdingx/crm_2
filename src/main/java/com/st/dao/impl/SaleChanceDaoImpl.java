package com.st.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.core.dao.impl.BaseDaoImpl;
import com.st.dao.SaleChanceDao;
import com.st.entity.SaleChanceEntity;

@Repository
public class SaleChanceDaoImpl extends BaseDaoImpl implements SaleChanceDao {

	@Override
	public List<SaleChanceEntity> find(SaleChanceEntity t) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByExample(t);
	}

	@Override
	public void save(SaleChanceEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaleChanceEntity> findAllPage(String hql, Integer first, Integer max) {
		// TODO Auto-generated method stub
		final String hqltemp = hql;
		return (List<SaleChanceEntity>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
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
	public void update(SaleChanceEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(SaleChanceEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaleChanceEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return (List<SaleChanceEntity>) getHibernateTemplate().find(hql);
	}

}
