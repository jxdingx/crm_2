package com.st.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.core.dao.impl.BaseDaoImpl;
import com.st.dao.ProductDao;
import com.st.entity.ProductEntity;
@Repository
public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {

	@Override
	public List<ProductEntity> find(ProductEntity t) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByExample(t);
	}

	@Override
	public void save(ProductEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEntity> findAll(String hql) {
		// TODO Auto-generated method stub
		return (List<ProductEntity>) getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEntity> findAllPage(String hql, Integer first, Integer max) {
		final String hqltemp = hql;
		return (List<ProductEntity>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
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
	public void update(ProductEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(ProductEntity t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public ProductEntity get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(ProductEntity.class, id);
	}

}
