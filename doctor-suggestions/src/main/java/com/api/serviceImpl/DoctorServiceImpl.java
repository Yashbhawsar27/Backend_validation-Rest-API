package com.api.serviceImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import com.api.exception.DoctorNotFoundException;
import com.api.exception.SpecialityNotFoundException;
import com.api.model.Doctor;
import com.api.repository.DoctorRepository;
import com.api.service.DoctorService;
import com.api.utility.Symptom;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public void saveDoctor(@Valid Doctor doctor) {

		doctorRepository.save(doctor);
	}

	public Doctor getDoctor(long did) {
		Doctor doctor = doctorRepository.findById(did)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor with id " + did + "does not exist"));

		return doctor;
	}

	public void removeDoctor(long did) {

		doctorRepository.deleteById(did);

	}

	public List<Doctor> getAllDoctor() {

		return doctorRepository.findAll();

	}

	public List<Doctor> getDoctorByCity(String city) {

		List<Doctor> doctorList = doctorRepository.findByCity(city);

		if (doctorList.isEmpty()) {
			throw new RuntimeException("doctor not found in this city please try in another city thank you .....");
		}

		return doctorList;
	}

	public List<Doctor> getDoctorbyCityAndDisese(String city, String disese) {

		String speciality = Symptom.map.get(disese);

		System.out.println(Symptom.map.get(disese));
		if (Symptom.map.get(disese) == null || Symptom.map.get(disese).isEmpty()) {
			
			throw new SpecialityNotFoundException(
					"doctor not found for this " + disese + " thank you ..... please connect nearest local dr");

		}

		if (!(speciality.equals("Orthopedic") || speciality.equals("Gynecology") || speciality.equals("Dermatology")
				|| speciality.equals("ENT"))) {
			throw new RuntimeException(
					"doctor not found for this " + disese + " thank you ..... please connect nearest local dr");

		}

		List<Doctor> doctorList = doctorRepository.findDoctorList(city, speciality);

		if (doctorList.isEmpty()) {
			throw new RuntimeException("doctor not found in this city please try in another city thank you .....");
		}
		return doctorList;
	}

	

}
