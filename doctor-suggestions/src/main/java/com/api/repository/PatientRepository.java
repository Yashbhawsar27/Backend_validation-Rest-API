package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
