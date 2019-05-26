package com.action;

import java.util.ArrayList;
import java.util.Date;
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
import com.vo.Fault;


@Component("callAction")
@Scope("prototype")
public class CallAction {

	private CallService callService;
    private Fault fault;
	private Employee emp;
    private String temp1;
	private FauService fauService;
	private String resultMessage;
	private String key;
	private String status;
	private String trueequ;
	private String endsta;
	private Call call;
	private List<Call> callList = new ArrayList<Call>();
	//当前页数
	private int pageNumber = 1;
	//总页数
	private int totalPage;
	
	
	

	


	public CallService getCallService() {
		return callService;
	}

	@Resource(name="callService")
	public void setCallService(CallService callService) {
		this.callService = callService;
	}


	


	//public FauService getFauService() {
	//	return fauService;
	//}

	//@Resource(name="fauService")
	//public void setFauService(FauService fauService) {
	//	this.fauService = fauService;
	//}

	public Fault getFault() {
		return fault;
	}

	public void setFau(Fault fault) {
		this.fault = fault;
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


	

	
	public String getTemp1() {
		return temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public Call getCall() {
		return call;
	}

	
	public void setCall(Call call) {
		this.call = call;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getTrueequ() {
		return trueequ;
	}

	public void setTrueequ(String trueequ) {
		this.trueequ = trueequ;
	}

	

	public String getEndsta() {
		return endsta;
	}

	public void setEndsta(String endsta) {
		this.endsta = endsta;
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


	//查询员工（分页）
	public String queryAll(){
		callList=callService.getAll();
		int maxRows = 10;
		int totalNumber = callList.size();
		totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
		totalPage = totalNumber;
		if(pageNumber>totalPage)pageNumber=totalNumber;
		int start = (pageNumber-1)*maxRows;
		callList = callService.getByPage(start, maxRows);
//			for(Sales s : salesList){
//				System.out.println(s);
//			}
		return "queryAll";
		
	}
	
	
	//修改
	public String update(){
		
		Map session = ActionContext.getContext().getSession();
		Employee emp = (Employee) session.get("emp");
		String role = emp.getEmp_role();
	//if(role.equals("维修工")||role =="维修工"){
			call = callService.getById(call.getCall_id());
			if(call.getCall_sta().equals("待审核") || call.getCall_sta() == "待审核"){
				call.setCall_sta("已审核");
				call.setReply_time(new Date());
				call.setEmployee(emp);
				callService.update(call);
			
				resultMessage = "审核成功";
			}else if(call.getCall_sta().equals("已审核") || call.getCall_sta() == "已审核"){
				resultMessage = "订单已经审核";
			}
//			System.out.println(sales);
			return "update";
			
		//}
		//else {
		//resultMessage = "您不是维修工，无法审核";
		//return "update";
		//}
	}
	//修改
		public String update2(){
			Map session = ActionContext.getContext().getSession();
			Employee emp = (Employee) session.get("emp");
			String role = emp.getEmp_role();
			call = callService.getById(call.getCall_id());
			if(call.getCall_sta().equals("已审核") || call.getCall_sta() == "已审核"){
				if(role.equals("员工")||role =="员工") {
					call.setEnd_time(new Date());
					callService.update(call);
				//setTemp1("1");//临时标记变量
				resultMessage = "操作工维修确认成功";
				}
				else {
					
					resultMessage = "您没有权限确认";
				}
			}else if(call.getCall_sta().equals("未审核") || call.getCall_sta() == "未审核"){
				resultMessage = "请先审核订单";
			}
//			System.out.println(sales);
			return "update2";		
		}
		
		public  String update3() {
			
			Map session = ActionContext.getContext().getSession();
			Employee emp = (Employee) session.get("emp");
			String role = emp.getEmp_role();
			call = callService.getById(call.getCall_id());
			if(role.equals("维修人员")||role =="维修人员"){
				if(call.getEnd_sta() != null) {
				call.setEnd_sta("已修复");
			//	setTemp1("0");
				//call.setEnd_time(new Date());
				callService.update(call);
				resultMessage = "维修确认成功";
				}
				else
				{
					
					resultMessage = "请操作工先确认";	
				}
				}
			else {
				
				resultMessage = "您没有权限";
			}
			return "update3";
		}
		
	//添加
	public String add(){
		callService.add(call);
		resultMessage = "添加成功";
		return "add";
		
	}
	
	//删除
	public String delete(){
//		System.out.println(sales.getSalesId());
		call = callService.getById(call.getCall_id());
		if(call.getCall_sta().equals("已审核") || call.getCall_sta() == "已审核"){
		
			callService.delete(call);
			resultMessage = "删除成功";
		}else if(call.getCall_sta().equals("待审核") || call.getCall_sta() == "待审核"){
			resultMessage = "待审核，不能删除";
		}
		return "delete";
		
	}
	
	//按关键字查询商品（分页）
	public String queryByKey(){
		callList=callService.queryByKey(key,status);
		int maxRows = 5;
		int totalNumber = callList.size();
		totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
		totalPage = totalNumber;
		if(pageNumber>totalPage)pageNumber=totalNumber;
		int start = (pageNumber-1)*maxRows;
		callList = callService.queryCallByKey(start, maxRows, key, status);
		return "queryByKey";
		
	}
	
	public String  queryByEmp() 
	{ String sta="未修复";
		callList=callService.queryByEmp("sta");
		int maxRows = 5;
		int totalNumber = callList.size();
		totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
		totalPage = totalNumber;
		if(pageNumber>totalPage)pageNumber=totalNumber;
		int start = (pageNumber-1)*maxRows;
		callList = callService.queryCallByEmp(start, maxRows, sta);;
		return "queryByEmp";
		
	}
	
	public String  queryByEqu() 
	{
		callList=callService.queryByEqu(trueequ,status);
		int maxRows = 5;
		int totalNumber = callList.size();
		totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
		totalPage = totalNumber;
		if(pageNumber>totalPage)pageNumber=totalNumber;
		int start = (pageNumber-1)*maxRows;
		callList = callService.getByPage(start, maxRows);
		return "queryByEqu";
		
	}
	
	/*public String queryByKey1(){
		callList=callService.queryByKey(key,status);
		int maxRows = 5;
		int totalNumber = callList.size();
		totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
		totalPage = totalNumber;
		if(pageNumber>totalPage)pageNumber=totalNumber;
		int start = (pageNumber-1)*maxRows;
		callList = callService.queryCallByKey(start, maxRows, key, status);
		return "queryByKey";
		
	}*/
}

