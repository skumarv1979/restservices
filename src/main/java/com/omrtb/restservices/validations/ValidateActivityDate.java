package com.omrtb.restservices.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyActivityDateValidator.class)
@Documented
public @interface ValidateActivityDate {

    String message() default "Date cannot be future date";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
