package com.employeeManagemnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagemnet.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
