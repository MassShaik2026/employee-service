package com.employee_service.wellsaid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employee_service.wellsaid.entity.Employee;

@Service
public class EmployeeService {

	
	
	
	public List<Employee> getEmployees(){
	return employees();
	}
	
	
	private List<Employee> employees(){
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("Shaik");
		e1.setDesignation("Developer");
		e1.setSalary(80000);
		
		Employee e2 = new Employee();
		e2.setId(1);
		e2.setName("Vijay");
		e2.setDesignation("Testing");
		e2.setSalary(100000);
		
		List<Employee> list = new ArrayList<>();
		list.add(e2);
		list.add(e1);
		return list;
		
	}
}
