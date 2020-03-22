package com.omrtb.restservices.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.omrtb.restservices.entity.model.User;

public class PasswordsEqualConstraintValidator implements ConstraintValidator<PasswordsEqualConstraint, Object> {

	@Override
	public void initialize(PasswordsEqualConstraint arg0) {
	}

	@Override
	public boolean isValid(Object candidate, ConstraintValidatorContext context) {
		User user = (User) candidate;
		return user.getPassword()!=null && user.getPassword().equals(user.getConfirmPassword());
	}
}