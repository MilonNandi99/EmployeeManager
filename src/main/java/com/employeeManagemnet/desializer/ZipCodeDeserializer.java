package com.employeeManagemnet.desializer;

import java.io.IOException;

import com.employeeManagemnet.enums.ZipCode;
import com.employeeManagemnet.exception.EnumException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ZipCodeDeserializer extends JsonDeserializer<ZipCode>{

	@Override
	public ZipCode deserialize(JsonParser p,DeserializationContext ctxt) throws IOException{
		String value=p.getText().toUpperCase();
		try {
		    return ZipCode.valueOf("ZIP_"+value);
		}catch(IllegalArgumentException e) {
			throw new EnumException("Invalid enum zipcode: "+value);
		}
//		catch(HttpMessageNotReadableException e) {
//			throw new EnumException("Invalid enum zipcode: "+value);
//		}
		
	}
}
