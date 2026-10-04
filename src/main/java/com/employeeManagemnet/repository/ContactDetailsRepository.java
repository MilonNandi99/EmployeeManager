package com.employeeManagemnet.repository;

import com.employeeManagemnet.entity.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Integer> {

}
