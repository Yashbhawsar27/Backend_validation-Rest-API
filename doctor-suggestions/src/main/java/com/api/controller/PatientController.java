package com.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Doctor;
import com.api.model.Patient;
import com.api.service.PatientService;

@RestController
@RequestMapping("patient")
public class PatientController 
{
	

	@Autowired
	private PatientService patientService;
	
	@PostMapping("add")
	public ResponseEntity<Patient>addPatient(@Valid @RequestBody Patient patient)
	{
		patientService.savePatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Patient>removePatient( @RequestParam long pid)
	{
		Patient patient= patientService.getPatient(pid);
		patientService.deletePatient(pid);
		return ResponseEntity.status(HttpStatus.OK).body(patient);
	}
	@GetMapping("doctor-list")
	public ResponseEntity<List<Doctor>> getDoctorList(@RequestParam long pid)
	{
		System.out.println("method called"+ pid);
		List<Doctor>doclist=patientService.getList (pid);
		return ResponseEntity.status(HttpStatus.OK).body(doclist);
	}
}
