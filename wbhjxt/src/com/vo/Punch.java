package com.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="punch_inf")
public class Punch {
	private int punch_id;
	private Part part;
	private Equipment equ;
	private Employee emp;
	private Date punch_time;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPunch_id() {
		return punch_id;
	}
	public void setPunch_id(int punch_id) {
		this.punch_id = punch_id;
	}
	@ManyToOne
	@JoinColumn(name="part_id")
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
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
	@JoinColumn(name="emp_id")
	public Employee getEmp() {
	return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Date getPunch_time() {
		return punch_time;
	}
	public void setPunch_time(Date punch_time) {
		this.punch_time = punch_time;
	}


}
