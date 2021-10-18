package com.somapay.transationmanager.domain;

import java.io.Serializable;

public class Transfer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Double value;
	private Employee employee;
	private Company company;
	
	public Transfer() {
	}

	public Transfer(Double value) {
		super();
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
