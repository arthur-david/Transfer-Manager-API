package com.somapay.transationmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somapay.transationmanager.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
