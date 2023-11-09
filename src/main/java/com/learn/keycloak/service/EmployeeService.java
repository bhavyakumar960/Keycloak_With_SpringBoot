package com.learn.keycloak.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.keycloak.dao.EmployeeRepository;
import com.learn.keycloak.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		List<Employee> empList = employeeRepository.findAll();
		if(empList.size()<1) {
			throw new NoSuchElementException("No employees found");
		}
		return empList;
	}

	
	public Employee getEmployeeById(Integer empId){
		Optional<Employee> oEmp = employeeRepository.findById(empId);
		if(!oEmp.isPresent()) {
			throw new NoSuchElementException("Employees not found with employee_id "+empId);
		}
		return oEmp.get();
	}
	
}
