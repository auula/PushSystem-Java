package com.service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.dao.PartDao;
import com.vo.Call;
import com.vo.Part;

@Component("partService")
public class PartService {
	private PartDao partDao;

	public PartDao getPartDao() {
		return partDao;
	}

	@Resource(name="partDao")
	public void setPartDao(PartDao partDao) {
		this.partDao = partDao;
	}
	
	
	public List<Part> Change(String type,String time,String name){
		List<Part> partList = partDao.Change(type, time,name);
		return partList;
		
	}
	
	//����
	public void add(Part part){
		partDao.add(part);
	}
	
	//ɾ��
	public void delete(Part part){
		partDao.delete(part);
	}
	
	//�޸�
	public void update(Part part){
		partDao.update(part);
	}
	
	//查询
	public List<Part> getAll(){
		return partDao.loadAll();
	}
	
	//����Ų�ѯ
	public Part getById(int id){
		return partDao.findById(id);
	}
	
	//��ҳ��ѯ
	public List<Part> getByPage(final int start,final int length){
		return partDao.getByPage(start, length);
	}
	public List<Part> queryByKey(String status) {
		return partDao.queryByKey(status);
	}
	public List<Part> queryPartByKey(final int start,final int length,final String status){
		return partDao.queryPartByKey(start, length, status);
	}
}


