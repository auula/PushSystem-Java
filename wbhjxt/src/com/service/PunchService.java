package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dao.PartDao;
import com.dao.PunchDao;
import com.vo.Part;
import com.vo.Punch;

@Component("punchService")
public class PunchService {
	private PunchDao punchDao;

	public PunchDao getPunchDao() {
		return punchDao;
	}
	@Resource(name="punchDao")
	public void setPunchDao(PunchDao punchDao) {
		this.punchDao = punchDao;
	}
	//增加
	public void add(Punch punch){
		punchDao.add(punch);
	}
	
	//删除
	public void delete(Punch punch){
		punchDao.delete(punch);
	}
	
	//修改
	public void update(Punch punch){
		punchDao.update(punch);
	}
	
	//查询
	public List<Punch> getAll(){
		return punchDao.loadAll();
	}
	public List<Punch> queryByKey(String status) {
		return punchDao.queryByKey(status);
	}
	public List<Punch> queryPunchByKey(final int start,final int length,final String status){
		return punchDao.queryPunchByKey(start, length, status);
	}
	//分页查询
	public List<Punch> getByPage(final int start,final int length){
		return punchDao.getByPage(start, length);
	}
	
}
