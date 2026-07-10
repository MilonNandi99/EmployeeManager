package com.employeeManagemnet.entity;

import com.employeeManagemnet.enums.DepartmentName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	@NotNull(message="Department name is mandatory")
	private DepartmentName departmentName;
}
