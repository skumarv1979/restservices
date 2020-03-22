package com.omrtb.restservices.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.omrtb.restservices.entity.model.ActivityType;

public class ActivityTypeValidator implements ConstraintValidator<ActivityTypeValidation, String> {

	@Override
	public boolean isValid(String activityType, ConstraintValidatorContext context) {

		if (activityType == null)
			return false;
		ActivityType obj = ActivityType.get(activityType);
		return obj!=null;
	}
}
