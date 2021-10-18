package com.somapay.transationmanager.dto;

import java.io.Serializable;

import com.somapay.transationmanager.domain.Company;

public class CompanyDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Double balance;
	
	public CompanyDTO() {
	}
	
	public CompanyDTO(Company obj) {
		id = obj.getId();
		name = obj.getName();
		balance = obj.getBalance();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
