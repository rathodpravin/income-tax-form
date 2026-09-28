package com.incomeTax.service;

import java.util.List;


import org.springframework.stereotype.Service;
import com.incomeTax.entity.EmployeeDetails;
import com.incomeTax.repository.EmployeeDetailsRepository;

@Service
public class EmployeeDetailsService {

	private final EmployeeDetailsRepository repository;

	public EmployeeDetailsService(EmployeeDetailsRepository repository) {
		this.repository = repository;
	}

	public EmployeeDetails saveEmployeeDetails(EmployeeDetails empDetails) {
		return repository.save(empDetails);
	}

	public List<EmployeeDetails> getAllEmployeeDetails() {
		return repository.findAll();
	}
	
	public EmployeeDetails getEmployeeDetailsById(Long id) {
		return repository.findById(id)
				.orElseThrow(()->new RuntimeException("Employee details not fount with "+id));
	}
	
	public void deleteEmployeeDetails(Long id) {
		repository.deleteById(id);
	}
	
	public EmployeeDetails updateEmployeeDetails(
	        Long id, EmployeeDetails empDetails) {

	    EmployeeDetails existingEmployee =
	            repository.findById(id)
	                    .orElseThrow(() ->
	                        new RuntimeException(
	                            "Employee details not found with " + id));

	    existingEmployee.setFullName(empDetails.getFullName());
	    existingEmployee.setPan(empDetails.getPan());
	    existingEmployee.setDob
	    (empDetails.getDob());
	    existingEmployee.setGender(empDetails.getGender());
	    existingEmployee.setParentName(empDetails.getParentName());
	    existingEmployee.setMaritalStatus(empDetails.getMaritalStatus());
	    existingEmployee.setMobile(empDetails.getMobile());
	    existingEmployee.setEmail(empDetails.getEmail());
	    existingEmployee.setAddress(empDetails.getAddress());
	    existingEmployee.setCity(empDetails.getCity());
	    existingEmployee.setState(empDetails.getState());
	    existingEmployee.setPincode(empDetails.getPincode());
	    existingEmployee.setIncomeSource(empDetails.getIncomeSource());
	    existingEmployee.setFinancialYear(empDetails.getFinancialYear());
	    existingEmployee.setAnnualIncome(empDetails.getAnnualIncome());
	    existingEmployee.setTds(empDetails.getTds());
	    existingEmployee.setOtherIncome(empDetails.getOtherIncome());
	    existingEmployee.setTaxRegime(empDetails.getTaxRegime());
	    existingEmployee.setAccountHolder(empDetails.getAccountHolder());
	    existingEmployee.setBankName(empDetails.getBankName());
	    existingEmployee.setAccountNumber(empDetails.getAccountNumber());
	    existingEmployee.setIfsc(empDetails.getIfsc());
	    existingEmployee.setAccountType(empDetails.getAccountType());

	    return repository.save(existingEmployee);
	}

}
