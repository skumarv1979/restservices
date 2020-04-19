package com.omrtb.restservices.request.model;

import java.io.Serializable;
import java.sql.Date;

public class UserEventActivities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String email;
	
	private Date pastDate;
	
	private Date activityDate;
	
	private Long movingTime;
	
	private Long elapsedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getPastDate() {
		return pastDate;
	}

	public void setPastDate(Date pastDate) {
		this.pastDate = pastDate;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public Long getMovingTime() {
		return movingTime;
	}

	public void setMovingTime(Long movingTime) {
		this.movingTime = movingTime;
	}

	public Long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
