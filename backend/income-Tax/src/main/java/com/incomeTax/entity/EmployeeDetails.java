package com.incomeTax.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fullName;
	private String pan;
    @JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private String gender;
	private String parentName;
	private String maritalStatus;

	private String mobile;
	private String email;
	private String address;
	private String city;
	private String state;
	private String pincode;

	private String incomeSource;
	private String financialYear;
	private BigDecimal annualIncome;
	private BigDecimal tds;
	private BigDecimal otherIncome;
	private String taxRegime;

	private String accountHolder;
	private String bankName;
	private String accountNumber;
	private String ifsc;
	private String accountType;

}
