package com.employeeManagemnet.exception;

public class InvalidZipCodeException extends RuntimeException{
	public InvalidZipCodeException(String errorMessage) {
		super(errorMessage);
	}

}
