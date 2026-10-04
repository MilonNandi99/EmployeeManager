package com.employeeManagemnet.desializer;

import java.io.IOException;

import com.employeeManagemnet.enums.DepartmentName;
import com.employeeManagemnet.exception.EnumException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DepartmentDeserializer extends JsonDeserializer<DepartmentName>{

	@Override
	public DepartmentName deserialize(JsonParser p,DeserializationContext ctxt) throws IOException{
	    String value=p.getText().toUpperCase();
	    try {
		    return DepartmentName.valueOf(value+"");
		}catch(IllegalArgumentException e) {
			throw new EnumException("Error: Invalid enum deparment name: "+value+"\nPlease enter a valid Department");
		}
	}
}
