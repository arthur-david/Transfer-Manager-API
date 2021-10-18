package com.somapay.transationmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somapay.transationmanager.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
