package com.employeeManagemnet.entity;

import com.employeeManagemnet.enums.DepartmentName;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = "department_name")
}
)
@Getter @Setter
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	@NotNull(message="Department name is mandatory")
	private DepartmentName departmentName;
}
