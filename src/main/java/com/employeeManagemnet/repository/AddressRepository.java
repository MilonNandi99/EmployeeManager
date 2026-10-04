package com.employeeManagemnet.repository;

import com.employeeManagemnet.enums.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagemnet.entity.Address;

import java.util.Optional;

//import com.employee.management.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

    Optional<Address> findByHouseNoAndLaneAndCityAndZipCode(
            int houseNo,
            String lane,
            String city,
            ZipCode zipCode);
}
