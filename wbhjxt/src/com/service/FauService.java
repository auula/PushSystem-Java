package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dao.EquipmentDao;
import com.dao.FaultDao;
import com.vo.Equipment;
import com.vo.Fault;

@Component("fauService")
public class FauService {
	private FaultDao fauDao;

	public FaultDao getFaultDao() {
		return fauDao;
	}

	@Resource(name="fauDao")
	public void setEquDao(FaultDao fauDao) {
		this.fauDao = fauDao;
	}
	//增加
			public void add(Fault Fault){
				fauDao.add(Fault);
			}
			
			//删除
			public void delete(Fault Fault){
				fauDao.delete(Fault);
			}
			
			//修改
			public void update(Fault Fault){
				fauDao.update(Fault);
			}
			
			//查询全部
			public List<Fault > getAll(){
				return fauDao.loadAll();
			}
			
			//按编号查询
			public Fault getById(int id){
				return fauDao.findById(id);
			}
			
			//分页查询
			public List<Fault> getByPage(final int start,final int length){
				return fauDao.getByPage(start, length);
			}
			
			//关键字分页查询
			public List<Fault> queryProByKey(final int start,final int length,final String name){
				return fauDao.queryFauByKey(start, length, name);
			}
			
			//关键字查询
			public List<Fault> queryByKey(String name) {
				return fauDao.queryByKey(name);
			}
			
		}
