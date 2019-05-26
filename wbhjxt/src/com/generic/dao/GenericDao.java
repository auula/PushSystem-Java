package com.generic.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T,PK extends Serializable> {
	
	public void add(T entity);
	
	public List<T> loadAll();
	
	public T findById(PK id);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public List getByPage(final int offest,final int length);
}
