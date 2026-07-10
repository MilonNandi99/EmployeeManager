package com.employeeManagemnet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter @Setter
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int empId;
	@NotBlank(message = "First name is mandatory")
	@Size(min=2,max=30,message="First name must be between 2 & 30 characters.")
	private String firstName;
	private String lastName;
	private int salary;
	@NotNull(message="Contact is mandatory.")
	@Digits(integer=10,fraction=0)
	private long contact;
	@ManyToOne
    @JoinColumn(name = "address_id")
	private Address address;
	@ManyToOne
    @JoinColumn(name = "department_id")
	@NotNull(message="Department is mandatory.")
	private Department department;
	
	
	
	public Employee() {
		
	}
	
	

	
}