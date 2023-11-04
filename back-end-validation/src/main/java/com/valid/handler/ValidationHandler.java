package com.valid.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.valid.model.User;

//@RestControllerAdvice
@RestController
@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{

	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
		
		
	 BindingResult br= ex.getBindingResult();
	 List<ObjectError> errorList=br.getAllErrors();
	 List<String>list=new ArrayList<>();
	 
	 for(ObjectError error : errorList) {
		 list.add(error.getDefaultMessage());
	 }
	  ValidationResponse response= new ValidationResponse("Validation failed....",list);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
