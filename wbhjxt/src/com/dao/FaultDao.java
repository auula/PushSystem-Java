package com.dao;

import java.util.List;

import com.generic.dao.GenericDao;
import com.vo.Equipment;
import com.vo.Fault;

public interface FaultDao extends GenericDao<Fault, Integer> {
	
	
	public List<Fault> queryByKey(String name);
	
	public  List<Fault> queryFauByKey(final int offest,final int length,final String name);
	}

