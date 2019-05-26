package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.generic.dao.GenericDaoImpl;
import com.vo.Call;

@Component("callDao")
public class CallDaoImpl extends GenericDaoImpl<Call,Integer> implements CallDao {

	@Override
	public List<Call> queryByKey(String name,String status) {
		if(name!=""&&status!=""){
			List<Call> callList = 
					super.getHibernateTemplate().find("from Call where equ.equ_name like '%"+name+"%' and call_sta ='"+status+"'");
			return callList;
		}
		else if(name!=""&&status==""){
			List<Call> callList = 
					super.getHibernateTemplate().find("from Call where equ.equ_name like '%"+name+"%'");
			return callList;
		}
		else if(name==""&&status!=""){
			List<Call> callList = 
					super.getHibernateTemplate().find("from Call where call_sta ='"+status+"'");
			return callList;
		}
		return null;
	}

	@Override
	public List<Call> queryCallByKey(final int offest,final int length,final String name,final String status) {
		if(name!=""&&status!=""){
			List list = super.getHibernateTemplate().executeFind(
					new HibernateCallback(){
						public Object doInHibernate(Session session){
							Query query = session.createQuery("from Call where equ.equ_name like '%"+name+"%' and call_Sta ='"+status+"'");
							query.setFirstResult(offest);
							query.setMaxResults(length);
							List list = query.list();
							return list;
						}
					});
			return list;
		}
		else if(name!=""&&status==""){
			List list = super.getHibernateTemplate().executeFind(
					new HibernateCallback(){
						public Object doInHibernate(Session session){
							Query query = session.createQuery("from Call where equ.equ_name like '%"+name+"%'");
							query.setFirstResult(offest);
							query.setMaxResults(length);
							List list = query.list();
							return list;
						}
					});
			return list;
		}
		else if(name==""&&status!=""){
			List list = super.getHibernateTemplate().executeFind(
					new HibernateCallback(){
						public Object doInHibernate(Session session){
							Query query = session.createQuery("from Call where call_sta ='"+status+"'");
							query.setFirstResult(offest);
							query.setMaxResults(length);
							List list = query.list();
							return list;
						}
					});
			return list;
		}
		return null;
	}

	@Override
	public List<Call> queryByEmp(String endsta) {
	
		 if(endsta!=""){
			List<Call> callList = 
					super.getHibernateTemplate().find("from Call where end_sta ='"+endsta+"'");
			return callList;
		}
		return null;
	}

//	@Override
	//public List<Call> queryByFau(int fid) {
	//	List<Call> callList = 
	//			super.getHibernateTemplate().find("from Call where fault_id ="+fid);
	//	return callList;
	//}

	@Override
	public List<Call> queryByEqu(String trueequ,String status) {
		if(trueequ!=""&&status!=""){
			List<Call> callList = 
					super.getHibernateTemplate().find("from Call where equ.equ_name like '%"+trueequ+"%' and call_sta ='"+status+"'");
			return callList;
		}
		else if(trueequ!=""&&status==""){
			List<Call> callList = 
					super.getHibernateTemplate().find("from Call where equ.equ_name like '%"+trueequ+"%'");
			return callList;
		}
		else if(trueequ==""&&status!=""){
			List<Call> callList = 
					super.getHibernateTemplate().find("from Call where call_sta ='"+status+"'");
			return callList;
		}
		return null;
	}
	
	@Override
	public List<Call> queryCallByEmp(final int offest,final int length,final String endsta) {
		if(endsta!=""){
			List list = super.getHibernateTemplate().executeFind(
					new HibernateCallback(){
						public Object doInHibernate(Session session){
							Query query = session.createQuery("from Call where end_sta like '%"+endsta+"%'");
							query.setFirstResult(offest);
							query.setMaxResults(length);
							List list = query.list();
							return list;
						}
					});
			return list;
		}
		return null;

	}
	
	/*@Override
	public List<Call> queryCallByEqu(final int offest,final int length,final String trueequ) {
		if(trueequ!=""){
			List list = super.getHibernateTemplate().executeFind(
					new HibernateCallback(){
						public Object doInHibernate(Session session){
							Query query = session.createQuery("from Call where equ.equ_name like '%"+trueequ+"%'");
							query.setFirstResult(offest);
							query.setMaxResults(length);
							List list = query.list();
							return list;
						}
					});
			return list;
		}
		return null;

	}*/
}
