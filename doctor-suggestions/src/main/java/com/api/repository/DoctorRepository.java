package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>
{


	@Query("from Doctor where city=:arg1 and speciality=:arg2")
	List<Doctor>findDoctorList(@Param("arg1") String city,@Param("arg2") String speciality);

	List<Doctor> findByCity(String city);
}
