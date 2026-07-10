package com.employeeManagemnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagemnet.entity.Address;
import com.employeeManagemnet.entity.Department;
import com.employeeManagemnet.entity.Employee;
import com.employeeManagemnet.enums.ZipCode;
import com.employeeManagemnet.repository.AddressRepository;
import com.employeeManagemnet.repository.DepartmentRepository;
import com.employeeManagemnet.repository.EmployeeRepository;



@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private DepartmentRepository departmentRepo;
	
	
	public void saveEmployee(Employee emp) {
		int addressId=emp.getAddress().getId();
		int deptId=emp.getDepartment().getId(); 
		if(emp.getAddress()!=null && addressId==0) {
			Address savedAddress=addressRepo.save(emp.getAddress());
			emp.setAddress(savedAddress);
		}
		if(emp.getDepartment()!=null && deptId==0) {
			Department savedDepartment=departmentRepo.save(emp.getDepartment());
			emp.setDepartment(savedDepartment);
		}
		empRepo.save(emp);
	}

	
	public List<Employee> getAllEmployee(){
		return empRepo.findAll();
	}
	
	public Optional<Employee> getEmployeeById(int id) {
		return empRepo.findById(id);
	}
	
	// updateEmployee method will change the employee details except the address.
	public void updateEmployee(int targetId,Employee empDetails) {
		Optional<Employee> optionalEmp=empRepo.findById(targetId);
		if(optionalEmp.isPresent()) {
//			Employee emp=optionalEmp.get();
//			emp.setFirstName(empDetails.getFirstName());
//			emp.setLastName(empDetails.getLastName());
//			emp.setSalary(empDetails.getSalary());
//			emp.setContact(empDetails.getContact());
			
			//AddressService.updateAddress()
			//need to work on and After do: 1. validation and 2. yaml using openApi dependency
			
			empRepo.save(optionalEmp.get());
		}
	}
	public void updateEmployeeSalary(int targetId,int newSalary ){
		Employee emp=empRepo.findById(targetId).get();
		emp.setSalary(newSalary);
	}
	 
	public void deleteEmployeeById(int id) {
		empRepo.deleteById(id);
	}
	
}