package com.employeeManagemnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagemnet.entity.Address;

//import com.employee.management.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
