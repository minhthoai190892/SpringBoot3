package com.example.demo.exception;

public class StudentNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public StudentNotFoundException(Throwable throwable) {
		super(throwable);
	}

}
