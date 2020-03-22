package com.omrtb.restservices.request.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.omrtb.restservices.validations.Email;

public class ForgotPasswordEmail {

    @NotNull(message = "Please provide email - null value")
    @NotEmpty(message = "Please provide email - blank value")
    @Email(message = "Invalid email")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
