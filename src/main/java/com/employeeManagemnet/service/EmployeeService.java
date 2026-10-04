package com.employeeManagemnet.service;

import java.util.List;
import java.util.Optional;

import com.employeeManagemnet.entity.ContactDetails;
import com.employeeManagemnet.repository.ContactDetailsRepository;
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
	@Autowired
	private ContactDetailsRepository contactDetailsRepo;
	
	
	public void saveEmployee(Employee emp) {
		if(emp.getContact()!=null){
			ContactDetails empContact = emp.getContact();
			Optional<ContactDetails> optExistingContact = contactDetailsRepo.findById(emp.getContact().getCid());
			if (optExistingContact.isPresent()) {
				emp.setContact(optExistingContact.get());
			}else{
				ContactDetails savedContact = contactDetailsRepo.save(empContact);
				emp.setContact(savedContact);
			}
		}

		if(emp.getAddress()!=null) {
			Address empAddress=emp.getAddress();
			Optional<Address> exitingAddress=addressRepo.findByHouseNoAndLaneAndCityAndZipCode(empAddress.getHouseNo(), empAddress.getLane(), empAddress.getCity(), empAddress.getZipCode());
			if(exitingAddress.isPresent()) {
				emp.setAddress(exitingAddress.get());
			}
			else{
				Address savedAddress= addressRepo.save(empAddress);
				emp.setAddress(savedAddress);
			}
		}
		if(emp.getDepartment()!=null) {
			Department dept=emp.getDepartment();
			Optional<Department> existingDept=departmentRepo.findByDepartmentName(dept.getDepartmentName());
			if(existingDept.isPresent()) {
				emp.setDepartment(existingDept.get());
			}else{
				Department savedDept= departmentRepo.save(dept);
				emp.setDepartment(savedDept);
			}
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
//
//			AddressService addressService=new AddressService();
//			addressService.updateAddress();
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