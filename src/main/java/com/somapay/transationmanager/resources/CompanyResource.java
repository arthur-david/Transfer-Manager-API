package com.somapay.transationmanager.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.somapay.transationmanager.domain.Company;
import com.somapay.transationmanager.domain.Employee;
import com.somapay.transationmanager.domain.Transfer;
import com.somapay.transationmanager.dto.CompanyDTO;
import com.somapay.transationmanager.dto.EmployeeDTO;
import com.somapay.transationmanager.services.CompanyService;

@RestController
@RequestMapping(value="/companies")
public class CompanyResource {
	
	@Autowired
	private CompanyService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insertCompany(@RequestBody Company obj) {
		obj = service.insertCompany(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CompanyDTO>> findAllCompanies() {
		List<Company> objs = service.searchAllCompanies();
		List<CompanyDTO> objsDto = objs.stream().map(obj -> new CompanyDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(objsDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Company> findCompany(@PathVariable Integer id) {
		Company obj = service.searchCompany(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCompany(@PathVariable Integer id) {
		service.deleteCompany(id);
		return ResponseEntity.noContent().build();
	}
	
//////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/{id}/employees",method=RequestMethod.POST)
	public ResponseEntity<Void> insertEmployee(@PathVariable Integer id, @RequestBody Employee obj) {
		obj = service.insertEmployee(id, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}/employees", method=RequestMethod.GET)
	public ResponseEntity<List<EmployeeDTO>> findAllEmployees(@PathVariable Integer id) {
		List<Employee> objs = service.searchAllEmployees(id);
		List<EmployeeDTO> objsDto = objs.stream().map(obj -> new EmployeeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(objsDto);
	}
	
	@RequestMapping(value="/{id1}/employees/{id2}", method=RequestMethod.GET)
	public ResponseEntity<Employee> findEmployee(@PathVariable Integer id1, @PathVariable Integer id2) {
		Employee obj = service.searchEmployee(id1, id2);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id1}/employees/{id2}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id1, @PathVariable Integer id2) {
		service.deleteEmployee(id1, id2);
		return ResponseEntity.noContent().build();
	}
	
//////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/{id1}/employees/{id2}", method=RequestMethod.PUT)
	public ResponseEntity<Transfer> transferBalance(@PathVariable Integer id1, @PathVariable Integer id2, @RequestBody Transfer objTransfer) {
		objTransfer = service.transferBalance(id1, id2, objTransfer);
		return ResponseEntity.ok().body(objTransfer);
	}
}
