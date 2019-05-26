package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.service.CallService;
import com.service.EmpService;
import com.service.EquService;
import com.service.FauService;
import com.vo.Call;
import com.vo.Employee;
import com.vo.Equipment;
import com.vo.Fault;

@Component("empAction")
@Scope("prototype")
public class EmpAction {
	private EmpService empService;
	private CallService callService;
	private EquService equService;
	private FauService fauService;
	private Employee emp;
	private String resultMessage;
	private String key;
	private List<Employee> empList = new ArrayList<Employee>();
	private List<Fault> fauList = new ArrayList<Fault>();

	private List<Equipment> equList = new ArrayList<Equipment>();
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
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
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
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
	public List<Fault> getFauList() {
		return fauList;
	}
	public void setFauList(List<Fault> fauList) {
		this.fauList = fauList;
	}
	public List<Equipment> getEquList() {
		return equList;
	}
	public void setEquList(List<Equipment> equList) {
		this.equList = equList;
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
	
	//
	/*登录action事件*/
	public String login(){
		Map session = ActionContext.getContext().getSession();
		String name = emp.getEmp_name();
		String pass = emp.getEmp_pass();
		String role = emp.getEmp_role();
//		System.out.println(name+":"+pass);
		List empList = empService.login(name, pass);
		if((empList.size()>0)){
			emp = (Employee) empList.get(0);
			session.put("emp", emp);
			return "login";
		}
		
		else{
			resultMessage = "用户名或密码错误，请重新登陆";
			return "input";
		}
		
	}
	//查询员工（分页）
		public String queryAll(){
			empList=empService.getAll();
			int maxRows = 5;
			int totalNumber = empList.size();
			totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
			totalPage = totalNumber;
			if(pageNumber>totalPage)pageNumber=totalNumber;
			int start = (pageNumber-1)*maxRows;
			empList = empService.getByPage(start, maxRows);
//				for(Product p : empList){
//					System.out.println(p);
//				}
			return "queryAll";
			
		}
		
		//按关键字查询员工（分页）
		public String queryByKey(){
			empList=empService.queryByKey(key);
			int maxRows = 5;
			int totalNumber = empList.size();
			totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
			totalPage = totalNumber;
			if(pageNumber>totalPage)pageNumber=totalNumber;
			int start = (pageNumber-1)*maxRows;
			empList = empService.queryProByKey(start, maxRows, key);

			return "queryByKey";
			
		}
		
		//修改
		public String update(){
			empService.update(emp);
			resultMessage = "修改成功";
			return "update";
			
		}
		
		//添加
		public String add(){
			empService.add(emp);
			resultMessage = "添加成功";
			return "add";
			
		}
		
	
		
	}


