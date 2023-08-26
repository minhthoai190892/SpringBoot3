package com.example.demo.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
	private String firstName;
	@NotNull(message = "is request")
	@Size(min = 1,message = "last name > 1")
	private String lastName;
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Customer() {
		super();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
