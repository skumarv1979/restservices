package com.omrtb.restservices.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.omrtb.restservices.request.model.PasswordDto;

public class ResetPasswordEqualConstraintValidator implements ConstraintValidator<ResetPasswordEqualConstraint, PasswordDto> {

	@Override
	public void initialize(ResetPasswordEqualConstraint arg0) {
	}

	@Override
	public boolean isValid(PasswordDto passwordDto, ConstraintValidatorContext context) {
		return passwordDto.getNewPassword()!=null && passwordDto.getNewPassword().equals(passwordDto.getConfirmNewPassword());
	}
}