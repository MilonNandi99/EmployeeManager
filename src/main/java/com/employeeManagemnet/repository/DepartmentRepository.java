package com.employeeManagemnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagemnet.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{

}
