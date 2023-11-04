package com.api.model;


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
public class Patient 
{
	@Id
	@GeneratedValue(generator = "pat_seq")
	@SequenceGenerator(name="pat_seq",initialValue = 1001,allocationSize = 1)
	private long patid;
	@NotNull(message = "Name is required")
	@Pattern(regexp = "^[a-zA-Z' ']{3,}$",message = "Only alphabets and space is allowed in name and length must be minimum 3")
	private String name;
	@NotNull(message = "City is required")
	@Size(max = 20,message = "City should be at max 20 characters")
	private String city;
	@Column(unique = true,length = 100)
	@Email(message = "Email id invalid")
	@NotNull(message = "Email is required")
	private String email;
	@Column(unique = true,length = 20)
	@NotNull(message = "Phone number is required")
	@Pattern(regexp = "^[0-9+-]{10,}$",message = "Invalid format of phone nmuber")
	private String phone;
	@NotNull(message = "Symptom is required")
	@Pattern(regexp = "Arthritis|Backpain|Tissue injuries|Dysmenorrhea|Skin infection|Skin burn|Ear pain",message = "Invalid symptom")
	private String symptom;
	public long getPatid() {
		return patid;
	}
	public void setPatid(long patid) {
		this.patid = patid;
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
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	



}
