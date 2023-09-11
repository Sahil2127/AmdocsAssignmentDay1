package com.amdocs.commonality.ddu.learning.standalone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.commonality.ddu.learning.standalone.model.EmployeeMissingSkillset;
import com.amdocs.commonality.ddu.learning.standalone.model.EmployeeSkillset;
import com.amdocs.commonality.ddu.learning.standalone.service.ValidateSkillApplicationService;

@RestController
@RequestMapping("/employeemanagement/v1")
public class ValidateSkills {
	
	@Autowired
	ValidateSkillApplicationService validateSkillApplicationService;
	
	@PostMapping("/validateEmployeeSkills")
	public ResponseEntity<EmployeeMissingSkillset> validateSkills(@RequestBody EmployeeSkillset employeeSkillSet) {
		
		EmployeeMissingSkillset employeeMissingSkillSet = validateSkillApplicationService.validateSkills(employeeSkillSet);
		
		return new ResponseEntity<EmployeeMissingSkillset>(employeeMissingSkillSet,HttpStatus.CREATED);
		
	}
	

}
