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
import com.service.PartService;
import com.service.PunchService;
import com.vo.Call;
import com.vo.Employee;
import com.vo.Equipment;
import com.vo.Fault;
import com.vo.Part;
import com.vo.Punch;

@Component("punchAction")
@Scope("prototype")
public class PunchAction {

	private EmpService empService;
	private CallService callService;
	private EquService equService;
	private PartService partService;
    private PunchService punchService;
	private Equipment equ;
	private Employee emp;
	private Punch punch;
	private Part part;
	private String resultMessage;
	private String key;
    private List<Punch> punchList =new ArrayList<Punch>();
    private List<Fault> fauList = new ArrayList<Fault>();
	private List<Employee> empList = new ArrayList<Employee>();
	private List<Equipment> equList = new ArrayList<Equipment>();
	private List<Call> callList = new ArrayList<Call>();
	private List<Part> partList = new ArrayList<Part>();
	
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
	public PartService getPartService() {
		return partService;
	}
	@Resource(name="partService")
	public void setPartService(PartService partService) {
		this.partService = partService;
	}
	public PunchService getPunchService() {
		return punchService;
	}
	@Resource(name="punchService")
	public void setPunchService(PunchService punchService) {
		this.punchService = punchService;
	}
	public Equipment getEqu() {
		return equ;
	}
	public void setEqu(Equipment equ) {
		this.equ = equ;
	}
	
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	public Punch getPunch() {
		return punch;
	}
	public void setPunch(Punch punch) {
		this.punch = punch;
	}
	
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
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
	public List<Part> getPartList() {
		return partList;
	}
	public void setPartList(List<Part> partList) {
		this.partList = partList;
	}
	public List<Punch> getPunchList() {
		return punchList;
	}
	public void setPunchList(List<Punch> punchList) {
		this.punchList = punchList;
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
	//按关键字查询设备（分页）
	public String queryAll(){
		//punchList=punchService.queryByKey(key);
		punchList=punchService.getAll();
		int maxRows = 10;
		int totalNumber = punchList.size();
		totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
		totalPage = totalNumber;
		if(pageNumber>totalPage)pageNumber=totalNumber;
		int start = (pageNumber-1)*maxRows;
		punchList = punchService.getByPage(start, maxRows);
		return "queryAll";
		
	}
	//修改
	public String update(){
		punchService.update(punch);
		resultMessage = "修改成功";
		return "update";
		
	}
	//添加
		public String add(){
			punchService.add(punch);
			resultMessage = "添加成功";
			return "add";
			
		}
	
	public String punchs(){
		
//		System.out.println(custom.getCustomId());
//		System.out.println(product.getProductId());
//		System.out.println(sales.getSalesNum());
		equ = equService.getById(equ.getEqu_id());
		//fault = fauService.getById(fault.getFault_id());
	    emp=empService.getById(emp.getEmp_id());
	
		part=partService.getById(part.getPart_id());
		
		//fauService.update(fault);
		punch.setEqu(equ);
		punch.setEmp(emp);
		punch.setPart(part);
		//call.setFault(fault);
		
	  //  call.setEmployee(emp);
		//call.setCall_sta("待审核");
		//call.setEnd_sta("未修复");
	    punch.setPunch_time(new Date());
	   // call.setEmployee(emp);
		punchService.add(punch);
	    queryAll();
		//resultMessage = "操作成功，请到订单管理查看详情";
		//punchService.update(punch);
		return "punchs";
		
	}
}
