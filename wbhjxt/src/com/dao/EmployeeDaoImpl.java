package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.generic.dao.GenericDaoImpl;
import com.vo.Employee;

@Component("empDao")
public class EmployeeDaoImpl extends GenericDaoImpl<Employee,Integer> implements EmployeeDao {

	@Override
	public List<Employee> login(String name, String pass) {
		List<Employee> empList = 
				super.getHibernateTemplate().find("from Employee where emp_name = '" +
					    name + "' and emp_pass = '" + pass + "'");
//		for(Employee emp : empList){
//			System.out.println(emp);
//			
//		}
		return empList;
	}

	@Override
	public List<Employee> queryByKey(String name) {
		List<Employee> empList = 
				super.getHibernateTemplate().find("from Employee where emp_name like '%"+name+"%'");
		return empList;
	}

	@Override
	public List<Employee> queryEmpByKey(final int offest,final int length,final String name) {
		List list = super.getHibernateTemplate().executeFind(
				new HibernateCallback(){
					public Object doInHibernate(Session session){
						Query query = session.createQuery("from Employee where emp_name like '%"+name+"%'");
						query.setFirstResult(offest);
						query.setMaxResults(length);
						List list = query.list();
						return list;
						}
					});
		return list;
	}

}
