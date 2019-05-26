package com.dao;

import java.util.List;

import com.generic.dao.GenericDao;
import com.vo.Call;
import com.vo.Equipment;

	public interface EquipmentDao extends GenericDao<Equipment, Integer> {
	
		
		public List<Equipment> queryByKey(String name);
		
		public List<Equipment> queryEquByKey(final int offest,final int length,final String name);
	}



