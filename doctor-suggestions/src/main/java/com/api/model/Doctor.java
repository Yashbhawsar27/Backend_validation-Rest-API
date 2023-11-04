package com.api.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(generator = "doc_seq")
	@SequenceGenerator(name="doc-seq",initialValue = 111, allocationSize = 1)
	private long docid;
	
	@NotNull(message = "Name is required")
	@Size(min=3, message="Name must have atleast three characters")
	private String name ;
	
	@Pattern(regexp = "Noida|Delhi|Faridabad",message = "City must be either Noid or Delhi or Faridabad")
	@NotNull(message = "city is required")
	private String city;
	
	@Column(unique = true, length = 100)
	@Email(message = "Email is invalid")
	@NotNull(message="Email is required")
	private String email;
	
	@Column(unique=true, length=20)
	@NotNull(message="phone number is required")
	@Size(min=10,message = "Phone number must have alteast 10 characters")
	private String phone;
	
	
	@NotNull(message="Speciality is required")
	@Pattern(regexp = "Orthopedic|Gynecology|Dermatology|ENT",message = "Invalid speciality choose only Orthopedic , Gyencology , Dermatology, ENT")
	private String speciality;



	public long getDocid() {
		return docid;
	}


	public void setDocid(long docid) {
		this.docid = docid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	
	
}
