package com.employeeManagemnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagemnet.entity.Address;
import com.employeeManagemnet.enums.ZipCode;
import com.employeeManagemnet.repository.AddressRepository;


@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepo;
	
	
	
	public void saveAddress(Address address) {
		addressRepo.save(address);
	}
	public List<Address> getAllAddress(){
		return addressRepo.findAll();
	}
	public void updateAddress(int targetId,Address addressDetails) {
		Optional<Address> optionalAddress=addressRepo.findById(targetId);
		if(optionalAddress.isPresent()) {
			Address address=optionalAddress.get();
			address.setHouseNo(addressDetails.getHouseNo());
			address.setLane(addressDetails.getLane());
			address.setCity(addressDetails.getCity());
			address.setZipCode(addressDetails.getZipCode());
			addressRepo.save(address);
		}	
	}
	
	
	public Optional<Address> getAddressById(int id) {
		return addressRepo.findById(id);
	}
	public void deleteAddressById(int id) {
		addressRepo.deleteById(id);
	}
}
