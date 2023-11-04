package com.api.exception;

public class PatientNotFoundException extends RuntimeException{

	public PatientNotFoundException(String msg)
	{
		super(msg);
	}
}
