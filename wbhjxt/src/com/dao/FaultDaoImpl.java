package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.generic.dao.GenericDaoImpl;
import com.vo.Equipment;
import com.vo.Fault;

@Component("fauDao")
public class FaultDaoImpl extends GenericDaoImpl< Fault,Integer> implements FaultDao {

	

	@Override
	public List<Fault> queryByKey(String name) {
		List<Fault> fauList = 
				super.getHibernateTemplate().find("from Fault where fault_type like '%"+name+"%'");
		return fauList;
	}

	@Override
	public List<Fault> queryFauByKey(final int offest,final int length,final String name) {
		List list = super.getHibernateTemplate().executeFind(
				new HibernateCallback(){
					public Object doInHibernate(Session session){
						Query query = session.createQuery("from Fault where fault_type like '%"+name+"%'");
						query.setFirstResult(offest);
						query.setMaxResults(length);
						List list = query.list();
						return list;
						}
					});
		return list;
	}

}
