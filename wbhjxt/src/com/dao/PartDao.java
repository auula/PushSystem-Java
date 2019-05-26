package com.dao;

import java.util.Date;
import java.util.List;

import com.generic.dao.GenericDao;

import com.vo.Part;

public interface PartDao extends GenericDao<Part, Integer> {
  
	public List<Part> Change(String type,String time,String name);
	public List<Part> queryByKey(String State);
	
	public List<Part> queryPartByKey(final int offest,final int length,final String status);
}
