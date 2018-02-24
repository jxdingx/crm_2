package com.st.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.core.dao.impl.BaseDaoImpl;
import com.st.dao.CusLinkManDao;
import com.st.entity.CusLinkManEntity;
@Repository
public class CusLinkManDaoImpl extends BaseDaoImpl implements CusLinkManDao {

	@Override
	public List<CusLinkManEntity> find(CusLinkManEntity t) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByExample(t);
	}

	@Override
	public void save(CusLinkManEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusLinkManEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return (List<CusLinkManEntity>) getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusLinkManEntity> findAllPage(String hql, Integer first, Integer max) {
		final String hqltemp = hql;
		return (List<CusLinkManEntity>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
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
	public void update(CusLinkManEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(CusLinkManEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public CusLinkManEntity get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CusLinkManEntity.class, id);
	}

}
