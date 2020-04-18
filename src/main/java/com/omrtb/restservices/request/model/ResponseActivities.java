package com.omrtb.restservices.request.model;

import java.io.Serializable;
import java.util.List;

import com.omrtb.restservices.entity.model.Activity;

public class ResponseActivities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int noOfDaysDone;
	
	private int noOfActualDaysPast;
	
	private int totalNoOfActivityDays;
	
	private List<Activity> activities;

	public int getNoOfDaysDone() {
		return noOfDaysDone;
	}

	public void setNoOfDaysDone(int noOfDaysDone) {
		this.noOfDaysDone = noOfDaysDone;
	}

	public int getNoOfActualDaysPast() {
		return noOfActualDaysPast;
	}

	public void setNoOfActualDaysPast(int noOfActualDaysPast) {
		this.noOfActualDaysPast = noOfActualDaysPast;
	}

	public int getTotalNoOfActivityDays() {
		return totalNoOfActivityDays;
	}

	public void setTotalNoOfActivityDays(int totalNoOfActivityDays) {
		this.totalNoOfActivityDays = totalNoOfActivityDays;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
