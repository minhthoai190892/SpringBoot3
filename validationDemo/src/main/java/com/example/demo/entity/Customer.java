package com.example.demo.entity;

import com.example.demo.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
	private String firstName;
	@NotNull(message = "is request")
	@Size(min = 1, message = "last name > 1")
	private String lastName;
	@NotNull(message = "is request")
	@Min(value = 0, message = "must be greater than or equal to zoro")
	@Max(value = 10, message = "must be greater than or equal to 10")
	private Integer freePassed;
	@Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 chars/digits")
	private String  postalCode;
	@CourseCode(value = "TOPS",message = "must start with TOPS")
	private String courseCode;
	
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer() {
		super();
	}

	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePassed() {
		return freePassed;
	}

	public void setFreePassed(Integer freePassed) {
		this.freePassed = freePassed;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
