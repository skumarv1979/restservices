package com.omrtb.restservices.request.model;

import java.sql.Date;

public interface UserEventActivitiesDto {

	public Long getId();

	public String getEmail();

	public Date getPastDate();

	public Date getActivityDate();

	public Long getMovingTime();

	public Long getElapsedTime();

	public Date getEventStartDate();

	public Integer getDay();

	public Integer getWeek();

}
