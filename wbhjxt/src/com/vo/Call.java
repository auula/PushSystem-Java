package com.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mysql.fabric.xmlrpc.base.Data;

@Entity
@Table(name="call_inf")
public class Call {
	private int call_id;
	private Employee  emp;
	private Equipment equ;
	private Fault fault;
	private String call_sta;
	private Date call_time;
	private Date reply_time;
	private Date end_time;
	private String call_num;
	private String end_sta;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCall_id() {
		return call_id;
	}
	public void setCall_id(int call_id) {
		this.call_id = call_id;
	}
	@ManyToOne
	@JoinColumn(name="emp_id")
	public Employee getEmployee() {
		return emp;
	}
	
	public void setEmployee(Employee emp) {
		this.emp = emp;
	}
	@ManyToOne
	@JoinColumn(name="equ_id")
	public Equipment getEqu() {
		return equ;
	}
	public void setEqu(Equipment equ) {
		this.equ = equ;
	}
	@ManyToOne
	@JoinColumn(name="fault_id")
	public Fault getFault() {
		return fault;
	}
	public void setFault( Fault fault) {
		this.fault =fault;
	}
	public String getCall_sta() {
		return call_sta;
	}
	public void setCall_sta(String call_sta) {
		this.call_sta = call_sta;
	}

	public String getEnd_sta() {
		return end_sta;
	}
	public void setEnd_sta(String end_sta) {
		this.end_sta = end_sta;
	}
	public Date getCall_time() {
		return call_time;
	}
	public void setCall_time(Date call_time) {
		this.call_time = call_time;
	}
	
	
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public String getCall_num() {
		return call_num;
	}
	public void setCall_num(String call_num) {
		this.call_num = call_num;
	}
	public Date getReply_time() {
		return reply_time;
	}
	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}
	

	
}
