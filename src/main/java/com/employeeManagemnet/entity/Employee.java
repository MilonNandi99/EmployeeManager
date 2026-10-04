package com.employeeManagemnet.entity;

import jakarta.persistence.*;
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cid")
	private ContactDetails contact;

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