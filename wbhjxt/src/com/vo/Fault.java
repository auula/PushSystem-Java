package com.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fault_inf")
public class Fault {
	private int fault_id;
	private String fault_describe;
	private String fault_type;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getFault_id() {
		return fault_id;
	}
	public void setFault_id(int fault_id) {
		this.fault_id = fault_id;
	}
	public String getFault_describe() {
		return fault_describe;
	}
	public void setFault_describe(String fault_describe) {
		this.fault_describe = fault_describe;
	}
	public String getFault_type() {
		return fault_type;
	}
	public void setFault_type(String fault_type) {
		this.fault_type = fault_type;
	}
	
	@Override
	public String toString() {
		return "Fault [fault_id=" + fault_id + ", fault_type="
				+ fault_type + ", fault_describe=" + fault_describe
				+ "]";
	}
	
	
}
