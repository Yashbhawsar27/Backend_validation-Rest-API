package com.api.service;

import java.util.List;

import javax.validation.Valid;

import com.api.model.Doctor;
import com.api.model.Patient;

public interface PatientService
{

	void savePatient(@Valid Patient patient);

	List<Doctor> getList(long pid);

	void deletePatient(long pid);

	Patient getPatient(long pid);

}
