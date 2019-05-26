package com.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipment_inf")
public class Equipment {
	private int equ_id;
	private String  equ_name;
	private String equ_sta;
	private String equ_type;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getEqu_id() {
		return equ_id;
	}
	public void setEqu_id(int equ_id) {
		this.equ_id = equ_id;
	}
	public String getEqu_name() {
		return equ_name;
	}
	public void setEqu_name(String equ_name) {
		this.equ_name = equ_name;
	}
	public String getEqu_sta() {
		return equ_sta;
	}
	public void setEqu_sta(String equ_sta) {
		this.equ_sta = equ_sta;
	}
	public String getEqu_type() {
		return equ_type;
	}
	public void setEqu_type(String equ_type) {
		this.equ_type = equ_type;
	}
	
	
	
}
