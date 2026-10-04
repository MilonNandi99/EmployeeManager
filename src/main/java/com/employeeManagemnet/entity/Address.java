package com.employeeManagemnet.entity;

import com.employeeManagemnet.desializer.ZipCodeDeserializer;
import com.employeeManagemnet.enums.ZipCode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@NotNull(message="Address is mandatory")
@Entity
@Table(uniqueConstraints = @UniqueConstraint(
		columnNames = {
				"house_no",
				"lane",
				"city",
				"zip_code"
		}
))
@Getter @Setter
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	@NotNull(message="House number is mandatory")
	private int houseNo;
	private String lane;
	@NotBlank(message="city is mandatory")
	private String city;
	
	@Enumerated(EnumType.STRING)
	@JsonDeserialize(using=ZipCodeDeserializer.class)
    @NotNull(message="Zipcode is mandatory")
	private ZipCode zipCode;
	

	public Address() {
		
	}
	
	public Address(int houseNo, String lane, String city, ZipCode zipCode) {
		super();
		this.houseNo = houseNo;
		this.lane = lane;
		this.city = city;
		this.zipCode = zipCode;
	}


}