package com.reece.application.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {

	@Override
	public boolean isValid(String contactField, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return contactField != null && contactField.matches("[0-9]+")
		          && (contactField.length() ==10);
	}

}
