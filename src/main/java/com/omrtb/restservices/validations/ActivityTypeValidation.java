package com.omrtb.restservices.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ActivityTypeValidator.class)
@Documented
public @interface ActivityTypeValidation {

    String message() default "Activity Type cannot be blank";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
