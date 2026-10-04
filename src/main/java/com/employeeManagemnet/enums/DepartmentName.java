package com.employeeManagemnet.enums;

import com.employeeManagemnet.desializer.DepartmentDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = DepartmentDeserializer.class)
public enum DepartmentName {

	HR,IT,MARKETING,SALES
}
