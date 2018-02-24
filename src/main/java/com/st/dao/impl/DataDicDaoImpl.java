package com.st.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.core.dao.impl.BaseDaoImpl;
import com.st.dao.DataDicDao;
import com.st.entity.DataDicEntity;
@Repository
public class DataDicDaoImpl extends BaseDaoImpl implements DataDicDao {

	@Override
	public List<DataDicEntity> find(DataDicEntity t) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByExample(t);
	}

	@Override
	public void save(DataDicEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataDicEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return (List<DataDicEntity>) getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataDicEntity> findAllPage(String hql, Integer first, Integer max) {
		final String hqltemp = hql;
		return (List<DataDicEntity>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
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
	public void update(DataDicEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(DataDicEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public DataDicEntity get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(DataDicEntity.class, id);
	}

}
