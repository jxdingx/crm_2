package com.st.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.core.dao.impl.BaseDaoImpl;
import com.st.dao.CusOrderDao;
import com.st.entity.CusOrderEntity;
@Repository
public class CusOrderDaoImpl extends BaseDaoImpl implements CusOrderDao {

	@Override
	public List<CusOrderEntity> find(CusOrderEntity t) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByExample(t);
	}

	@Override
	public void save(CusOrderEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusOrderEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return (List<CusOrderEntity>) getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusOrderEntity> findAllPage(String hql, Integer first, Integer max) {
		final String hqltemp = hql;
		return (List<CusOrderEntity>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
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
	public void update(CusOrderEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(CusOrderEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public CusOrderEntity get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CusOrderEntity.class, id);
	}

}
