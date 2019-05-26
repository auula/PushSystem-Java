package com.dao;

import java.util.List;

import com.generic.dao.GenericDao;
import com.vo.Call;

public interface CallDao extends GenericDao<Call, Integer>{
	
	public List<Call> queryByKey(String name,String status);
	
	public List<Call> queryCallByKey(final int offest,final int length,final String name,final String status );
	
	public List<Call> queryByEmp(String endsta);
	
	//public List<Call> queryByFau(int fid);
	
	public List<Call> queryByEqu(String trueequ,String status);
	
	public List<Call> queryCallByEmp(final int offest,final int length,final String endsta );
	
	//public List<Call> queryCallByEqu(final int offest,final int length,final String trueequ );
}
