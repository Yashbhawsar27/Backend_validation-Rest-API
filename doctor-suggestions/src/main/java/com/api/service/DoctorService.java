package com.api.service;

import java.util.List;

import javax.validation.Valid;

import com.api.model.Doctor;

public interface DoctorService {

	void saveDoctor(@Valid Doctor doctor);

	Doctor getDoctor(long did);

	void removeDoctor(long did);

	List<Doctor> getAllDoctor();

	List<Doctor> getDoctorByCity(String city);

	List<Doctor> getDoctorbyCityAndDisese(String city, String disese);


}
 