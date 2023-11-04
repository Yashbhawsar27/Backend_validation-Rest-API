package com.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.exception.SpecialityNotFoundException;
import com.api.model.Doctor;
import com.api.service.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping("add")
	public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);

	}

	@GetMapping("getDoctor/{did}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable long did) {

		Doctor doctor = doctorService.getDoctor(did);

		return ResponseEntity.ok(doctor);
	}

	@GetMapping("getAllDoctor")
	public ResponseEntity<List<Doctor>> getAllDoctor() {
		List<Doctor> doctorList = doctorService.getAllDoctor();
		return ResponseEntity.ok(doctorList);
	}

	@GetMapping("getDoctorByCity/{city}")
	public ResponseEntity<List<Doctor>> getDoctorByCity(@PathVariable String city) {
		List<Doctor> doctorList = doctorService.getDoctorByCity(city);

		return ResponseEntity.status(HttpStatus.FOUND).body(doctorList);
	}

	@GetMapping("searchdoctorbydisese/{city}/{disese}")
	public ResponseEntity<List<Doctor>> getDoctorsByDisese(@PathVariable String city, @PathVariable String disese) {
		List<Doctor> doctorList = doctorService.getDoctorbyCityAndDisese(city, disese);
		return ResponseEntity.status(HttpStatus.FOUND).body(doctorList);
	}

	@PutMapping("updateDoctor/{did}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable long did, @RequestBody Doctor doctor) {
		System.out.println("update called");
		Doctor oldDr = doctorService.getDoctor(did);

		oldDr.setCity(doctor.getCity());
		doctorService.saveDoctor(oldDr);

		return ResponseEntity.status(HttpStatus.OK).body(oldDr);

	}

	@DeleteMapping("delete")
	public ResponseEntity<Doctor> deleteDoctor(@RequestParam long did) {

		Doctor doctor = doctorService.getDoctor(did);
		doctorService.removeDoctor(did);
		return ResponseEntity.ok(doctor);
	}

}
