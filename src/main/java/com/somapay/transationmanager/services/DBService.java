package com.somapay.transationmanager.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somapay.transationmanager.domain.Company;
import com.somapay.transationmanager.domain.Employee;
import com.somapay.transationmanager.repositories.CompanyRepository;
import com.somapay.transationmanager.repositories.EmployeeRepository;

@Service
public class DBService {
	
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void instantiateTestDatabase() {
		Company cp1 = new Company(null, "Cocacola", 100000.0);
		Company cp2 = new Company(null, "Amazon", 1000000.0);
		
		Employee e1 = new Employee(null, "Arthur Silva", 500.0);
		Employee e2 = new Employee(null, "Elivania Rodrigues", 600.0);
		Employee e3 = new Employee(null, "Anton Castillo", 1200.0);
		Employee e4 = new Employee(null, "Clara Garcia", 1000.0);
		
		cp1.getEmployees().addAll(Arrays.asList(e1, e2, e3));
		cp2.getEmployees().addAll(Arrays.asList(e3, e4));
		
		e1.getCompanies().addAll(Arrays.asList(cp1));
		e2.getCompanies().addAll(Arrays.asList(cp1));
		e3.getCompanies().addAll(Arrays.asList(cp1, cp2));
		e4.getCompanies().addAll(Arrays.asList(cp2));
		
		companyRepository.saveAll(Arrays.asList(cp1, cp2));
		employeeRepository.saveAll(Arrays.asList(e1,e2,e3,e4));
	}
}
