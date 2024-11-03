package com.employee_service.wellsaid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_service.wellsaid.entity.Employee;
import com.employee_service.wellsaid.service.EmployeeService;

@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path = "/get_employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	
	
	
}
