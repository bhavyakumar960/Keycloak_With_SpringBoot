package com.learn.keycloak;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.keycloak.dao.EmployeeRepository;
import com.learn.keycloak.entity.Employee;

@SpringBootApplication
public class KeycloakWithSpringBootApplication {

	@Autowired
	private EmployeeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(KeycloakWithSpringBootApplication.class, args);
	}

	
	@PostConstruct
	public void saveToDB() {
		repository.saveAllAndFlush(getAllEmployee());
	}
	
	private List<Employee> getAllEmployee(){
		return Stream.of(
				new Employee(null, "Bhavya", "Pitampura, Delhi", "9878675467", "2023-10-10"),
				new Employee(null, "Lakshay", "Rani Chowk, Ghaziabad", "9987678098", "2023-11-10"),
				new Employee(null, "Rohit", "Pitampura, Delhi", "8076897656", "2023-08-04"),
				new Employee(null, "Gayatri", "Gautam Buddha Nagar", "9787656789", "2023-06-05")
				).collect(Collectors.toList());
		
	}
}
