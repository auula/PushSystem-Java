package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.service.CallService;
import com.service.EmpService;
import com.service.EquService;
import com.service.FauService;
import com.vo.Call;
import com.vo.Employee;
import com.vo.Equipment;
import com.vo.Fault;

@Component("equAction")
@Scope("prototype")
public class EquAction {
	private EmpService empService;
	private CallService callService;
	private EquService equService;
	private FauService fauService;

	private Equipment equ;
	private String resultMessage;
	private String key;
	private List<Equipment> equList = new ArrayList<Equipment>();
	private List<Fault> fauList = new ArrayList<Fault>();
	private List<Employee> empList = new ArrayList<Employee>();

	private List<Call> callList = new ArrayList<Call>();
	//当前页数
	private int pageNumber = 1;
	//总页数
	private int totalPage;
	public EmpService getEmpService() {
		return empService;
	}
	@Resource(name="empService")
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	public CallService getCallService() {
		return callService;
	}
	@Resource(name="callService")
	public void setCallService(CallService callService) {
		this.callService = callService;
	}
	public EquService getEquService() {
		return equService;
	}
	@Resource(name="equService")
	public void setEquService(EquService equService) {
		this.equService = equService;
	}
	public FauService getFauService() {
		return fauService;
	}
	@Resource(name="fauService")
	public void setFauService(FauService fauService) {
		this.fauService = fauService;
	}
	
	public Equipment getEqu() {
		return equ;
	}
	public void setEqu(Equipment equ) {
		this.equ = equ;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<Equipment> getEquList() {
		return equList;
	}
	public void setEquList(List<Equipment> equList) {
		this.equList = equList;
	}
	
	public List<Fault> getFauList() {
		return fauList;
	}
	public void setFauList(List<Fault> fauList) {
		this.fauList = fauList;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	public List<Call> getCallList() {
		return callList;
	}
	public void setCallList(List<Call> callList) {
		this.callList = callList;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	//查询设备（分页）
			public String queryAll(){
				equList=equService.getAll();
				int maxRows = 5;
				int totalNumber = equList.size();
				totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
				totalPage = totalNumber;
				if(pageNumber>totalPage)pageNumber=totalNumber;
				int start = (pageNumber-1)*maxRows;
				equList = equService.getByPage(start, maxRows);
//					for(Product p : empList){
//						System.out.println(p);
//					}
				return "queryAll";
				
			}
			
			//按关键字查询设备（分页）
			public String queryByKey(){
				equList=equService.queryByKey(key);
				int maxRows = 5;
				int totalNumber = equList.size();
				totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
				totalPage = totalNumber;
				if(pageNumber>totalPage)pageNumber=totalNumber;
				int start = (pageNumber-1)*maxRows;
				equList = equService.queryProByKey(start, maxRows, key);

				return "queryByKey";
				
			}
			
			//修改
			public String update(){
				equService.update(equ);
				resultMessage = "修改成功";
				return "update";
				
			}
			
			//添加
			public String add(){
				equService.add(equ);
				resultMessage = "添加成功";
				return "add";
				
			}
			
			//删除
			public String delete(){
				equ = equService.getById(equ.getEqu_id());
				
						equService.delete(equ);
						resultMessage = "删除成功";
			            return "delete";
			}
			
		}

