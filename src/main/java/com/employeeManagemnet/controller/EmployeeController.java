package com.employeeManagemnet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagemnet.entity.Address;
import com.employeeManagemnet.entity.Department;
import com.employeeManagemnet.entity.Employee;
import com.employeeManagemnet.exception.ResourceNotFoundException;
import com.employeeManagemnet.service.AddressService;
import com.employeeManagemnet.service.DepartmentService;
import com.employeeManagemnet.service.EmployeeService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/details")


public class EmployeeController {

	@Autowired
	private EmployeeService service;
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@PostMapping("/employee/save")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee empDetails ) {
		try {
		  service.saveEmployee(empDetails);
	      return ResponseEntity.status(HttpStatus.CREATED).body("Saved! Employee");
		}catch(ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployee(){
		
		return service.getAllEmployee();
	}
	
	@GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Optional<Employee> emp = service.getEmployeeById(id);
        if (emp.isPresent()) {
            return ResponseEntity.ok(emp.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

	@PutMapping("/employee/update/{targetId}")
	public ResponseEntity<String> updateEmployee(@PathVariable int targetId,@Valid @RequestBody Employee empDetails) {
        try {
        	service.updateEmployee(targetId, empDetails);
            return ResponseEntity.ok("Updated! Employee");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
	
	
	@PutMapping("/employee/updatesalary/{targetId}")
	public ResponseEntity<String> updateEmplyeeSalary(@PathVariable int targetId, @Valid @RequestBody int salary){
		try {
			service.updateEmployeeSalary(targetId, salary);
			return ResponseEntity.ok("Updated! Employee's salary");
		}catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
		
	}
    
	 
	@DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
	     service.deleteEmployeeById(id);
	     return ResponseEntity.ok("Deleted! Employee");
	}
	 
	
	
	
	
	
	
	@PostMapping("/address/save")
	public ResponseEntity<String> addAddress(@Valid @RequestBody Address addressDetails ) {
		try {
		  addressService.saveAddress(addressDetails);
	      return ResponseEntity.status(HttpStatus.CREATED).body("Address Saved!");
		}catch(ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
//		
		
	}
	
	@GetMapping("/getAllAddresses")
	public List<Address> getAllAddress(){
		
		return addressService.getAllAddress();
	}
	
	@GetMapping("/getAddress/{targetId}")
	public ResponseEntity<Address> getAddressById(@PathVariable int targetId){
		Optional<Address> address= addressService.getAddressById(targetId);
		if(address.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(address.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PutMapping("/address/update/{targetId}")
	public ResponseEntity<String> updateAddress(@PathVariable int targetId,@Valid @RequestBody Address address){
		try{
			addressService.updateAddress(targetId, address);
		    return ResponseEntity.ok("Address Updated!");
		}catch(ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	@DeleteMapping("/address/delete/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable int id){
		
			addressService.deleteAddressById(id);
			return ResponseEntity.ok("Address Deleted!");
	}
	
	
	
	
	
	
	
	@PostMapping("/department/save")
	public ResponseEntity<String> addDeparment(@Valid @RequestBody Department department){
		try {
			departmentService.saveDepartment(department);
			return ResponseEntity.status(HttpStatus.CREATED).body("Department saved!");
		}catch(ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments(){
		return departmentService.getAllDepartment();
	}
	
	@GetMapping("/getDepartment/{targetId}")
	public ResponseEntity<Department> getDepartmentById(int id){
		Optional<Department> optDept=departmentService.getDepartmentById(id);
		if(optDept.isPresent()) {
			return ResponseEntity.ok(optDept.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PutMapping("/department/update/{targetId}")
	public ResponseEntity<String> updateDepartment(@PathVariable int targetId,@Valid @RequestBody Department department){
		try{
			departmentService.updateDepartment(targetId, department);
		    return ResponseEntity.ok("Department Updated!");
		}catch(ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}	
	}
	
	@DeleteMapping("/department/delete/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable int id){
		
			departmentService.deleteDepartment(id);
			return ResponseEntity.ok("Department Deleted!");
	}
	 
	}
	