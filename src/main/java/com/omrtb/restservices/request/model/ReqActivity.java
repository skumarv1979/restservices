package com.omrtb.restservices.request.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omrtb.restservices.validations.ActivityTypeValidation;
import com.omrtb.restservices.validations.ValidateActivityDate;

public class ReqActivity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private String sourceData;
	
	//@JsonIgnore
    private long activityId;
    
	@NotNull(message = "Please provide Date")
	@ValidateActivityDate(message = "Activity date should be in past 7 days")
    private Date startDate;
    
    private Float distance;
    
    private String movingTime;

    @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]", flags = Flag.UNICODE_CASE, message = "Please provide elapsed time in hh:mm:ss format for ex 24:59:59")
    private String elapsedTime;
    
    private String workoutName;
    
    private String workoutType;

    @ActivityTypeValidation(message = "Activity type can be Run, Ride, Swim")
    @NotNull(message = "Activity Type cannot be null")
    private String activityType;
    
	public String getSourceData() {
		return sourceData;
	}

	public void setSourceData(String sourceData) {
		this.sourceData = sourceData;
	}

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public Date getStartDate() {
		return startDate;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public String getWorkoutName() {
		return workoutName;
	}

	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMovingTime() {
		return movingTime;
	}

	public void setMovingTime(String movingTime) {
		this.movingTime = movingTime;
	}

	public String getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

    
}
