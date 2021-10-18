package com.somapay.transationmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.somapay.transationmanager.domain.Company;
import com.somapay.transationmanager.domain.Employee;
import com.somapay.transationmanager.domain.Transfer;
import com.somapay.transationmanager.repositories.CompanyRepository;
import com.somapay.transationmanager.repositories.EmployeeRepository;
import com.somapay.transationmanager.services.exceptions.DataIntegrityException;
import com.somapay.transationmanager.services.exceptions.InvalidOperationException;
import com.somapay.transationmanager.services.exceptions.ObjectNotFoundException;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository repoComp;
	@Autowired
	private EmployeeRepository repoEmp;
	
	public Company insertCompany(Company obj) {
		obj.setId(null);
		return repoComp.save(obj);
	}
	
	public List<Company> searchAllCompanies() {
		List<Company> objs = repoComp.findAll();
		if (objs.size() == 0) {
			throw new ObjectNotFoundException(
				"Nothing Object Found! Type: " + Company.class.getName());
		}
		return objs;
	}
	
	public Company searchCompany(Integer id) {
		Optional<Company> obj = repoComp.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Object Not Found! Id: " + id + ", Type: " + Company.class.getName()));
	}
	
	public void deleteCompany(Integer id) {
		searchCompany(id);
		try {
			repoComp.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It is not possible to delete! Delete all existing employees.");
		}
		
	}
	
////////////////////////////////////////////////////////
	
	public Employee insertEmployee(Integer id, Employee obj) {
		obj.setId(null);
		Company objComp = repoComp.findById(id).get();
		objComp.getEmployees().add(obj);
		obj.getCompanies().add(objComp);
		repoComp.save(objComp);
		return repoEmp.save(obj);
	}
	
	public List<Employee> searchAllEmployees(Integer id) {
		Company objComp = searchCompany(id);
		List<Employee> objEmp = objComp.getEmployees();
		if (objEmp.size() == 0) {
			throw new ObjectNotFoundException(
				"Nothing Object Found! Type: " + Employee.class.getName());
		}
		return objEmp;
	}
	
	public Employee searchEmployee(Integer id1, Integer id2) {
		searchCompany(id1);
		Optional<Employee> objEmp = repoEmp.findById(id2);
		return objEmp.orElseThrow(() -> new ObjectNotFoundException(
				"Object Not Found! Id: " + id2 + ", Type: " + Employee.class.getName()));
	}
	
	public void deleteEmployee(Integer id1, Integer id2) {
		Employee objEmp = searchEmployee(id1, id2);
		repoEmp.deleteById(objEmp.getId());
	}
	
//////////////////////////////////////////////////////////
	
	public Transfer transferBalance(Integer id1, Integer id2, Transfer objTransfer) {
		Company objComp = searchCompany(id1);
		if ((objComp.getBalance() - objTransfer.getValue()) < 0) {
			throw new InvalidOperationException(
				"Invalid Transfer! Id Company: " + id1 + ", Id Employee: " + id2);
		}
		objComp.setBalance(objComp.getBalance() - objTransfer.getValue());
		repoComp.save(objComp);
		
		List<Employee> listEmployee = objComp.getEmployees();
		if (id2 > listEmployee.size() || id2 < 1) {
			throw new ObjectNotFoundException(
				"Object Not Found! Id: " + id2 + ", Type: " + Employee.class.getName());
		}
		Employee objEmp = listEmployee.get(id2-1);
		objEmp.setBalance(objEmp.getBalance() + objTransfer.getValue());
		repoEmp.save(objEmp);
		
		objTransfer.setCompany(objComp);
		objTransfer.setEmployee(objEmp);
		
		return objTransfer;
	}
}
