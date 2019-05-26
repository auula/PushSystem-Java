package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dao.CallDao;
import com.vo.Call;
import com.vo.Employee;



@Component("callService")
public class CallService {
	private CallDao callDao;
	
	public CallDao getSalesDao() {
		return callDao;
	}

	@Resource(name="callDao")
	public void setCallDao(CallDao callDao) {
		this.callDao = callDao;
	}

	//����
	public void add(Call call){
		callDao.add(call);
	}
	
	//ɾ��
	public void delete(Call call){
		callDao.delete(call);
	}
	
	//�޸�
	public void update(Call call){
		callDao.update(call);
	}
	
	//��ѯȫ��
	public List<Call> getAll(){
		return callDao.loadAll();
	}
	
	//����Ų�ѯ
	public Call getById(int id){
		return callDao.findById(id);
	}

	
	//��ҳ��ѯ
	public List<Call> getByPage(final int start,final int length){
		return callDao.getByPage(start, length);
	}
	
	//�ؼ��ַ�ҳ��ѯ
	public List<Call> queryCallByKey(final int start,final int length,final String name,final String status){
		return callDao.queryCallByKey(start, length, name, status);
	}
		
	//�ؼ��ֲ�ѯ
	public List<Call> queryByKey(String name,String status) {
		return callDao.queryByKey(name, status);
	}
	public List<Call> queryByEmp(String endsta) {
		
		return callDao.queryByEmp(endsta);
	}
public List<Call> queryByEqu(String trueequ,String status) {
		
		return callDao.queryByEqu(trueequ,status);
	}
/*public List<Call> queryCallByEqu(final int start,final int length,final String trueequ){
	return callDao.queryCallByEqu(start, length, trueequ);
}*/
public List<Call> queryCallByEmp(final int start,final int length,final String endsta){
	return callDao.queryCallByEmp(start, length, endsta);
}

}

