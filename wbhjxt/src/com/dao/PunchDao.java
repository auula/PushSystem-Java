package com.dao;

import java.util.List;

import com.generic.dao.GenericDao;
import com.vo.Employee;
import com.vo.Equipment;
import com.vo.Punch;

public interface PunchDao extends GenericDao<Punch, Integer> {
	public List<Punch> queryByKey(String name);
	
	public List<Punch> queryPunchByKey(final int offest,final int length,final String name);
}
