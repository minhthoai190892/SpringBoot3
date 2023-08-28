package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	private String courcePrefix;

	@Override
	public void initialize(CourseCode theCourseCode) {
		// TODO Auto-generated method stub
		courcePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean result;
		if (value != null) {
			result = value.startsWith(courcePrefix);
		} else {
			result = true;
		}
		return result;
	}

}
