package com.incomeTax.controller;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incomeTax.entity.EmployeeDetails;
import com.incomeTax.service.EmployeeDetailsService;

@RestController
@RequestMapping("/api/employee_details")
@CrossOrigin(origins = "*")
public class EmployeeDetailsController {

	private final EmployeeDetailsService service;

	public EmployeeDetailsController(EmployeeDetailsService service) {
		this.service = service;
	}

	@PostMapping
	public EmployeeDetails saveEmployeeDetails(@RequestBody EmployeeDetails empDetails) {
		return service.saveEmployeeDetails(empDetails);
	}

	@GetMapping
	public List<EmployeeDetails> getAllEmployeeDetails() {
		return service.getAllEmployeeDetails();
	}

	@GetMapping("/{id}")
	public EmployeeDetails getEmployeeDetailsById(@PathVariable Long id) {
		return service.getEmployeeDetailsById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployeeDetails(@PathVariable long id) {
		service.deleteEmployeeDetails(id);
		return "Empolyee details deleted successfully..";
	}
	
	@PutMapping("/{id}")
	public EmployeeDetails updateEmployeeDetails(
	        @PathVariable Long id,
	        @RequestBody EmployeeDetails empDetails) {

	    return service.updateEmployeeDetails(id, empDetails);
	}

}
