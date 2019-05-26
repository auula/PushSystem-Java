package com.generic.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class GenericDaoImpl<T,PK extends Serializable> implements GenericDao<T,PK>  {

	private Class<T> clazz;
	
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@SuppressWarnings("unchecked")
	public GenericDaoImpl(){
		clazz = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void add(T entity) {
		hibernateTemplate.save(entity);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> loadAll() {
		return hibernateTemplate.find("from " + clazz.getName());
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(PK id) {
		// TODO Auto-generated method stub
		return (T) hibernateTemplate.get(clazz, id);
	}

	@Override
	public void update(T entity) {
		hibernateTemplate.update(entity);
		
	}

	@Override
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
		
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List getByPage(final int offest, final int length) {
		
		List list = hibernateTemplate.executeFind(
				new HibernateCallback(){
					public Object doInHibernate(Session session){
						Query query = session.createQuery("from " + clazz.getName());
						query.setFirstResult(offest);
						query.setMaxResults(length);
						List list = query.list();
						return list;
					}
				});
		return list;
	}
	
}
