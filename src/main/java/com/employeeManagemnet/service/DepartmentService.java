package com.employeeManagemnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagemnet.entity.Department;
import com.employeeManagemnet.repository.DepartmentRepository;


@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository deptRepo;
	
	public void saveDepartment(Department dept) {
		deptRepo.save(dept);
	}
	
	public List<Department> getAllDepartment(){
		return deptRepo.findAll();
	}
	
	public Optional<Department> getDepartmentById(int id) {
		return deptRepo.findById(id);
	}
	
	public void updateDepartment(int deptId, Department newDept) {
		Department department=deptRepo.findById(deptId).get();
		department.setDepartmentName(newDept.getDepartmentName());
		deptRepo.save(department);
	}
	
	public void deleteDepartment(int deptId) {
		Department department=deptRepo.findById(deptId).get();
		deptRepo.delete(department);
	}
}
