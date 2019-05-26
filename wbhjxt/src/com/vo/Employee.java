package com.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_inf")
public class Employee {
	private int emp_id;
	private String emp_name;
	private String emp_pass;
	private String emp_role;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_pass() {
		return emp_pass;
	}

	public void setEmp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}

	public String getEmp_role() {
		return emp_role;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}
	
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name="
				+ emp_name + ", emp_pass=" + emp_pass
				+ ", emp_role=" + emp_role + "]";
	}

	
}
