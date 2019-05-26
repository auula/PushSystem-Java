package com.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;
import com.generic.dao.GenericDaoImpl;
import com.vo.Call;
import com.vo.Employee;
import com.vo.Part;

@Component("partDao")
public class PartDaoImpl extends GenericDaoImpl<Part,Integer> implements PartDao {
	public List<Part> Change(String type,String time,String name)
	{
		List<Part> partList = 
				super.getHibernateTemplate().find("from Part where part_name = '" +
					    name + "' and part_type = '" + type + "'and part_time='"+time+"'");
		return partList;
	}
	
	@Override
	public List<Part> queryByKey(String status) {
		
		
		if(status!=""){
			List<Part> partList = 
					super.getHibernateTemplate().find("from Part where part_sta ='"+status+"'");
			
			return partList;
		}
		return null;
	}

	@Override
	public List<Part> queryPartByKey(final int offest,final int length,final String status) {
		List list = super.getHibernateTemplate().executeFind(
				new HibernateCallback(){
					public Object doInHibernate(Session session){
						Query query = session.createQuery("from Part where part_sta like '%"+status+"%'");
						query.setFirstResult(offest);
						query.setMaxResults(length);
						List list = query.list();
						return list;
						}
					});
		return list;
	}
}
