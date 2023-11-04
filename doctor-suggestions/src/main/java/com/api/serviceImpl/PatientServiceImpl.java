package com.api.serviceImpl;

import java.util.List;
import java.util.function.Supplier;

import javax.management.loading.PrivateClassLoader;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.exception.PatientNotFoundException;
import com.api.model.Doctor;
import com.api.model.Patient;
import com.api.repository.DoctorRepository;
import com.api.repository.PatientRepository;
import com.api.service.PatientService;
import com.api.utility.Symptom;

@Service
public class PatientServiceImpl implements PatientService
{
	@Autowired
	private PatientRepository patientRepository;

	
	@Autowired
	private DoctorRepository doctorRepository;
	
	
	public void savePatient(@Valid Patient patient)
	{
		patientRepository.save(patient);
		
	}

	public List<Doctor> getList(long pid) {
		Patient patient=patientRepository.findById(pid).orElseThrow( ()-> new PatientNotFoundException("Patient with"+pid+" does not found"));
		
		String city=patient.getCity();
		
		if(!city.equals("Noida")&& !city.equals("Faridabad")&& !city.equals("Delhi"))
				{
			        throw new RuntimeException("we are still waiting to expand to your Location"); 
 				}
		
		
		String symptom=patient.getSymptom();
		
		String speciality=Symptom.map.get(symptom);
		
		List<Doctor>dlist=doctorRepository.findDoctorList(city,speciality);
	   
		if(dlist.isEmpty())
		{
			throw new RuntimeException("There isn't any doctor present at your Location"); 
			}
		
		System.out.println(dlist);
		return dlist;
	}


	
	public Patient getPatient(long pid) {
	
		Patient patient=patientRepository.findById(pid).orElseThrow( ()-> new PatientNotFoundException("Patient with"+pid+" does not found"));
		
		return patient;
	}

	
	public void deletePatient(long pid) {
		patientRepository.deleteById(pid);
	}

	
	

	

	

	
}
