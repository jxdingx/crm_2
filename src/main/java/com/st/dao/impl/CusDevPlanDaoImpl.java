package com.st.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.core.dao.impl.BaseDaoImpl;
import com.st.dao.CusDevPlanDao;
import com.st.entity.CusDevPlanEntity;

@Repository
public class CusDevPlanDaoImpl extends BaseDaoImpl implements CusDevPlanDao {

	@Override
	public List<CusDevPlanEntity> find(CusDevPlanEntity t) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByExample(t);
	}

	@Override
	public void save(CusDevPlanEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusDevPlanEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return (List<CusDevPlanEntity>) getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CusDevPlanEntity> findAllPage(String hql, Integer first, Integer max) {
		final String hqltemp = hql;
		return (List<CusDevPlanEntity>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
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
	public void update(CusDevPlanEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(CusDevPlanEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public CusDevPlanEntity get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CusDevPlanEntity.class, id);
	}

}
