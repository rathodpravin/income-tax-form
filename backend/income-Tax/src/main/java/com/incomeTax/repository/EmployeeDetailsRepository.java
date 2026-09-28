package com.incomeTax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incomeTax.entity.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

}
