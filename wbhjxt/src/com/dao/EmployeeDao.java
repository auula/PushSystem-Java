package com.dao;

import java.util.List;

import com.generic.dao.GenericDao;
import com.vo.Employee;


	public interface EmployeeDao extends GenericDao<Employee, Integer> {
		public List<Employee> login(String name,String pass);
		
		public List<Employee> queryByKey(String name);
		
		public List<Employee> queryEmpByKey(final int offest,final int length,final String name);
	}


