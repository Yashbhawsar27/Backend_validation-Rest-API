package com.valid.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {

	@NotNull(message = "Userid is required")
	private String userid;
	
	
	
	
	@NotNull(message = "Password is required")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,15}$",message = "Password is not strong")
	private String password;
	
	
	@NotNull(message = "Name is required")
	@Pattern(regexp =  "^[a-zA-Z' ']*$",message = "Name is not valid")
	private String name;
	
	
	
	
	@NotNull(message = "Country is required")
	@Pattern(regexp = "India|Nepal|Bangladesh",message = "Not a vlaid country")
	private String country;
	
	
	
	@Min(value = 1,message = "Age is required")
	private int age;
	
	
	@NotNull(message = "Email is required")

@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email is not valid")

	private String email;
	
	
	
	@NotNull(message = "Phone number is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number is not valid")

	private String phone;

	
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

}
