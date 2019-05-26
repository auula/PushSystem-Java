package com.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="part_inf")
public class Part {

	private int part_id;
	private String part_name;
	private String part_type;
	private String  part_time;
	private String  part_sta;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPart_id() {
		return part_id;
	}
	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public String getPart_type() {
		return part_type;
	}
	public void setPart_type(String part_type) {
		this.part_type = part_type;
	}
	public String  getPart_time() {
		return part_time;
	}
	public void setPart_time(String part_time) {
		this.part_time = part_time;
	}
	public String getPart_sta() {
		return part_sta;
	}
	public void setPart_sta(String part_sta) {
		this.part_sta = part_sta;
	}
	
}
