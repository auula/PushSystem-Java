package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.generic.dao.GenericDaoImpl;
import com.vo.Part;
import com.vo.Punch;

@Component("punchDao")
public class PunchDaoImpl extends GenericDaoImpl<Punch,Integer> implements PunchDao{
	
	
	@Override
	public List<Punch> queryByKey(String status) {
		
		
		if(status!=""){
			List<Punch> punchList = 
					super.getHibernateTemplate().find("from Punch where punch_id ='"+status+"'");
			
			return punchList;
		}
		return null;
	}

	@Override
	public List<Punch> queryPunchByKey(final int offest,final int length,final String status) {
		List list = super.getHibernateTemplate().executeFind(
				new HibernateCallback(){
					public Object doInHibernate(Session session){
						Query query = session.createQuery("from punch where punch_id like '%"+status+"%'");
						query.setFirstResult(offest);
						query.setMaxResults(length);
						List list = query.list();
						return list;
						}
					});
		return list;
	}
}
