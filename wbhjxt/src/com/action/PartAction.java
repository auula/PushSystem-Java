package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.service.PartService;

import com.vo.Part;

@Component("partAction")
@Scope("prototype")
public class PartAction {
	
	private PartService partService;
	private Part part;
	private String resultMessage;
	private String key;
	
	private String status;
	private List<Part> partList = new ArrayList<Part>();
	
	//StringBuffer sb = new StringBuffer();
	//当前页数
	private int pageNumber = 1;
	//总页数
	private int totalPage;
	//添加set and get 方法
	public PartService getPartService() {
		return partService;
	}
	@Resource(name="partService")
	public void setPartService(PartService partService) {
		this.partService = partService;
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
	public List<Part> getPartList() {
		return partList;
	}
	public void setPartList(List<Part> partList) {
		this.partList = partList;
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
			//查询员工（分页）
			public String queryAll(){
				partList=partService.getAll();
				int maxRows = 5;
				int totalNumber = partList.size();
				totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
				totalPage = totalNumber;
				if(pageNumber>totalPage)pageNumber=totalNumber;
				int start = (pageNumber-1)*maxRows;
				partList = partService.getByPage(start, maxRows);
//					for(Product p : empList){
//						System.out.println(p);
//					}
				return "queryAll";
				
			}
			
			
			
			//修改
			public String update(){
				part.setPart_sta("下班");
				partService.update(part);
				resultMessage = "修改成功";
				return "update";
				
			}
			
			//添加
			public String add(){
				part.setPart_sta("班中");
				partService.add(part);
				resultMessage = "添加成功";
				
			
				return "add";
				
			}
			//删除
			public String delete(){
				part = partService.getById(part.getPart_id());
				
						partService.delete(part);
						resultMessage = "删除成功";
			            return "delete";
			}
			
			//按关键字查询商品（分页）
			public String queryByKey(){
				part.setPart_sta("班中");
				partService.add(part);
				String sta="班中";
				partList=partService.queryByKey(sta);
				int maxRows = 5;
				int totalNumber = partList.size();
				totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
				totalPage = totalNumber;
				if(pageNumber>totalPage)pageNumber=totalNumber;
				int start = (pageNumber-1)*maxRows;
				partList = partService.queryPartByKey(start, maxRows,  sta);
				return "queryByKey";
				
			}	
			//按关键字查询商品（分页）
			public String queryByKey1(){
				
				String sta="班中";
				partList=partService.queryByKey(sta);
				int maxRows = 5;
				int totalNumber = partList.size();
				totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
				totalPage = totalNumber;
				if(pageNumber>totalPage)pageNumber=totalNumber;
				int start = (pageNumber-1)*maxRows;
				partList = partService.queryPartByKey(start, maxRows,  sta);
				return "queryByKey1";
				
			}	
}
