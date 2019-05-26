package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.generic.dao.GenericDaoImpl;
import com.vo.Equipment;


@Component("equDao")
public class EquipmentDaoImpl extends GenericDaoImpl<Equipment,Integer> implements EquipmentDao {

	

	@Override
	public List<Equipment> queryByKey(String name) {
		List<Equipment> equList = 
				super.getHibernateTemplate().find("from Equipment where equ_name like '%"+name+"%'");
		return equList;
	}

	@Override
	public List<Equipment> queryEquByKey(final int offest,final int length,final String name) {
		List list = super.getHibernateTemplate().executeFind(
				new HibernateCallback(){
					public Object doInHibernate(Session session){
						Query query = session.createQuery("from Equipment where equ_name like '%"+name+"%'");
						query.setFirstResult(offest);
						query.setMaxResults(length);
						List list = query.list();
						return list;
						}
					});
		return list;
	}

}
