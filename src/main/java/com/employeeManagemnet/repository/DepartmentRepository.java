package com.employeeManagemnet.repository;

import com.employeeManagemnet.enums.DepartmentName;
import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagemnet.entity.Department;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{

    Optional<Department> findByDepartmentName(DepartmentName departmentName);
}
