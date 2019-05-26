package com.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.dao.EmployeeDao;
import com.vo.Employee;

@Component("empService")
public class EmpService {
	private EmployeeDao empDao;

	public EmployeeDao getEmpDao() {
		return empDao;
	}

	@Resource(name="empDao")
	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}
	
	
	public List<Employee> login(String name, String pass){
		List<Employee> empList = empDao.login(name, pass);
		return empList;
		
	}
	
	//����
	public void add(Employee Employee){
		empDao.add(Employee);
	}
	
	//ɾ��
	public void delete(Employee Employee){
		empDao.delete(Employee);
	}
	
	//�޸�
	public void update(Employee Employee){
		empDao.update(Employee);
	}
	
	//��ѯȫ��
	public List<Employee> getAll(){
		return empDao.loadAll();
	}
	
	//����Ų�ѯ
	public Employee getById(int id){
		return empDao.findById(id);
	}
	
	//��ҳ��ѯ
	public List<Employee> getByPage(final int start,final int length){
		return empDao.getByPage(start, length);
	}
	
	//�ؼ��ַ�ҳ��ѯ
	public List<Employee> queryProByKey(final int start,final int length,final String name){
		return empDao.queryEmpByKey(start, length, name);
	}
	
	//�ؼ��ֲ�ѯ
	public List<Employee> queryByKey(String name) {
		return empDao.queryByKey(name);
	}
	
}

