package com.st.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.core.dao.impl.BaseDaoImpl;
import com.st.dao.CusLossDao;
import com.st.entity.CusLossEntity;
@Repository
public class CusLossDaoImpl extends BaseDaoImpl implements CusLossDao {

	@Override
	public List<CusLossEntity> find(CusLossEntity t) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByExample(t);
	}

	@Override
	public void save(CusLossEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusLossEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return (List<CusLossEntity>) getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusLossEntity> findAllPage(String hql, Integer first, Integer max) {
		final String hqltemp = hql;
		return (List<CusLossEntity>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
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
	public void update(CusLossEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(CusLossEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public CusLossEntity get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CusLossEntity.class, id);
	}

}
