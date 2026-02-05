package com.employeeManagemnet.entity;

import com.employeeManagemnet.desializer.ZipCodeDeserializer;
import com.employeeManagemnet.enums.ZipCode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull(message="House number is mandatory")
	private int houseNo;
	private String lane;
	@NotBlank(message="city is mandatory")
	private String city;
	
	@Enumerated(EnumType.STRING)
	@JsonDeserialize(using=ZipCodeDeserializer.class)
    @NotNull(message="Zipcode is mandatory")
    //@Size(min=6,max=7)
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