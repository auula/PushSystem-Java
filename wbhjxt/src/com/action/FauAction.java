package com.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.service.CallService;
import com.service.EmpService;
import com.service.EquService;
import com.service.FauService;
import com.utils.JsonData;
import com.utils.JsonUtil;
import com.vo.Call;

import com.vo.Employee;
import com.vo.Equipment;
import com.vo.Fault;
import com.vo.Pull;
import com.vo.PullThread;
import com.vo.PullValue;

@Component("fauAction")
@Scope("prototype")
public class FauAction {
	private Pull pull = Pull.getInstance();
	private CallAction callAction;
	private EmpService empService;
	private CallService callService;
	private EquService equService;
	private FauService fauService;
	private Equipment equ;
	private Employee emp;
	private Fault fault;
	private Call call;
	private String resultMessage;
	private String key;
	private List<Fault> fauList = new ArrayList<Fault>();
	private List<Employee> empList = new ArrayList<Employee>();
	private List<Equipment> equList = new ArrayList<Equipment>();
	private List<Call> callList = new ArrayList<Call>();
	// 当前页数
	private int pageNumber = 1;
	// 总页数
	private int totalPage;

	public EmpService getEmpService() {
		return empService;
	}

	@Resource(name = "empService")
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	public CallService getCallService() {
		return callService;
	}

	@Resource(name = "callService")
	public void setCallService(CallService callService) {
		this.callService = callService;
	}

	public EquService getEquService() {
		return equService;
	}

	@Resource(name = "equService")
	public void setEquService(EquService equService) {
		this.equService = equService;
	}

	public FauService getFauService() {
		return fauService;
	}

	@Resource(name = "fauService")
	public void setFauService(FauService fauService) {
		this.fauService = fauService;
	}

	public CallAction getCallAction() {
		return callAction;
	}

	@Resource(name = "callAction")
	public void setCallAction(CallAction callAction) {
		this.callAction = callAction;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public Call getCall() {
		return call;
	}

	public void setCall(Call call) {
		this.call = call;
	}

	public Equipment getEqu() {
		return equ;
	}

	public void setEqu(Equipment equ) {
		this.equ = equ;
	}

	public List<Equipment> getEquList() {
		return equList;
	}

	public void setEquList(List<Equipment> equList) {
		this.equList = equList;
	}

	public Fault getFault() {
		return fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
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

	// 查询设备（分页）
	public String queryAll() {
		fauList = fauService.getAll();
		int maxRows = 5;
		int totalNumber = fauList.size();
		totalNumber = totalNumber / maxRows + (totalNumber % maxRows == 0 ? 0 : 1);
		totalPage = totalNumber;
		if (pageNumber > totalPage)
			pageNumber = totalNumber;
		int start = (pageNumber - 1) * maxRows;
		fauList = fauService.getByPage(start, maxRows);
//					for(Product p : empList){
//						System.out.println(p);
//					}
		equList = equService.getAll();
		callList = callService.getAll();
		return "queryAll";

	}

	// 查询呼叫订单

	// 按关键字查询设备（分页）
	public String queryByKey() {
		fauList = fauService.queryByKey(key);
		int maxRows = 20;
		int totalNumber = fauList.size();
		totalNumber = totalNumber / maxRows + (totalNumber % maxRows == 0 ? 0 : 1);
		totalPage = totalNumber;
		if (pageNumber > totalPage)
			pageNumber = totalNumber;
		int start = (pageNumber - 1) * maxRows;
		fauList = fauService.queryProByKey(start, maxRows, key);
		equList = equService.getAll();
		callList = callService.getAll();
		return "queryByKey";

	}

	// 修改
	public String update() {

		fauService.update(fault);
		resultMessage = "修改成功";
		return "update";

	}

	// 添加
	public String add() {
		fauService.add(fault);
		resultMessage = "添加成功";
		return "add";

	}

	// 删除
	public String delete() {
		fault = fauService.getById(fault.getFault_id());

		fauService.delete(fault);
		resultMessage = "删除成功";
		return "delete";
	}

	public String calls() {
		HttpServletRequest request = ServletActionContext.getRequest();

		Map session = ActionContext.getContext().getSession();
		Employee emp = (Employee) session.get("emp");
		if (emp == null) {
			resultMessage = "请登陆后再执行此操作";
			return "fail";
		}
//				System.out.println(custom.getCustomId());
//				System.out.println(product.getProductId());
//				System.out.println(sales.getSalesNum());
		equ = equService.getById(equ.getEqu_id());
		fault = fauService.getById(fault.getFault_id());
		// emp=empService.getById(emp.getEmp_id());

		fauService.update(fault);
		call.setEqu(equ);
		call.setFault(fault);

		// call.setEmployee(emp);
		call.setCall_sta("待审核");
		call.setEnd_sta("未修复");
		call.setCall_time(new Date());
		// call.setEmployee(emp);
		callService.add(call);
		callAction.queryAll();
		resultMessage = "操作成功，请到订单管理查看详情";
		callService.update(call);
		// 使用了单例设计模式 请求唯一id
		pull.getCurrent().add(UUID.randomUUID().toString());
		PullThread pt = new PullThread(pull.getFilterList(), pull.getCurrent());
		pt.start();
		return "calls";
	}


	public void pull() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		if(pull.isNewMessage()) {
			if(pull.Contain(request.getSession().getId())) {
				//System.out.println("pull1");
				JsonUtil.outJson(response, new JsonData().build(2001, "当前sessionID为"+request.getSession().getId()+"的浏览器已经推送提醒消息~请及时查看最新订单！！30秒之后如果还有新的订单将重新提醒！！"));
			}else {
				//System.out.println("pull2");
				pull.setFList(request.getSession().getId());
				JsonUtil.outJson(response, new JsonData().build(2000, "有新的推送订单需要处理~"));
			}
		}else {
			//System.out.println("pull3");
			JsonUtil.outJson(response, new JsonData().build(-2000, "没有新消息处理~请继续等待~"));
		}
	}

}
