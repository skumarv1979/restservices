package com.omrtb.restservices.validations;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyActivityDateValidator implements ConstraintValidator<ValidateActivityDate, Date> {
	public void initialize(ValidateActivityDate constraint) {
	}

	public boolean isValid(Date value, ConstraintValidatorContext context) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, -7);
		return value!=null && !value.after(new Date()) && !value.before(c.getTime());
	}
}