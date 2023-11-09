package com.learn.keycloak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.keycloak.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
