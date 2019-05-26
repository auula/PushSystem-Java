package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dao.EquipmentDao;
import com.vo.Employee;
import com.vo.Equipment;



@Component("equService")
public class EquService {
	private EquipmentDao equDao;

	public EquipmentDao getEquDao() {
		return equDao;
	}

	@Resource(name="equDao")
	public void setEquDao(EquipmentDao equDao) {
		this.equDao = equDao;
	}
	
	//增加
		public void add(Equipment Equipment){
			equDao.add(Equipment);
		}
		
		//删除
		public void delete(Equipment Equipment){
			equDao.delete(Equipment);
		}
		
		//修改
		public void update(Equipment Equipment){
			equDao.update(Equipment);
		}
		
		//查询全部
		public List<Equipment > getAll(){
			return equDao.loadAll();
		}
		
		//按编号查询
		public Equipment getById(int id){
			return equDao.findById(id);
		}
		
		//分页查询
		public List<Equipment> getByPage(final int start,final int length){
			return equDao.getByPage(start, length);
		}
		
		//关键字分页查询
		public List<Equipment> queryProByKey(final int start,final int length,final String name){
			return equDao.queryEquByKey(start, length, name);
		}
		
		//关键字查询
		public List<Equipment> queryByKey(String name) {
			return equDao.queryByKey(name);
		}
		
	}

