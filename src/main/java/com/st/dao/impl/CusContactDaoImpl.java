package com.st.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.core.dao.impl.BaseDaoImpl;
import com.st.dao.CusContactDao;
import com.st.entity.CusContactEntity;
@Repository
public class CusContactDaoImpl extends BaseDaoImpl implements CusContactDao {

	@Override
	public List<CusContactEntity> find(CusContactEntity t) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByExample(t);
	}

	@Override
	public void save(CusContactEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusContactEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return (List<CusContactEntity>) getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusContactEntity> findAllPage(String hql, Integer first, Integer max) {
		final String hqltemp = hql;
		return (List<CusContactEntity>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
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
	public void update(CusContactEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(CusContactEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public CusContactEntity get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CusContactEntity.class, id);
	}

}
