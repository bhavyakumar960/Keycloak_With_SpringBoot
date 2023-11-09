package com.learn.keycloak.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.keycloak.entity.Employee;
import com.learn.keycloak.service.EmployeeService;
import com.learn.keycloak.utils.ErrorResponse;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	@Autowired
	private ErrorResponse errorResponse;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> getAllEmployees() {
		 try {
			 List<Employee> employees = service.getAllEmployees();
			 return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return errorResponse.getResponse(HttpStatus.NOT_FOUND, e.getMessage());
		}catch (Exception e) {
			return errorResponse.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	
	@GetMapping(value = "/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed("USER")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer empId) {
		try {
			Employee employee = service.getEmployeeById(empId);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return errorResponse.getResponse(HttpStatus.NOT_FOUND, e.getMessage());
		}catch (Exception e) {
			return errorResponse.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
}
