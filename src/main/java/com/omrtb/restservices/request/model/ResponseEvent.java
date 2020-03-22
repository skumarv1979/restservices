package com.omrtb.restservices.request.model;

import java.io.Serializable;
import java.util.Date;

import com.omrtb.restservices.entity.model.Events;
import com.omrtb.restservices.entity.model.User;

public class ResponseEvent implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String name;
    
    private Date startDate;

    private Date endDate;
    
    private String status;

    private boolean isRegistered;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
    
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof User) {
			User u = (User)obj;
			return this.getId().equals(u.getId());
		}
		return super.equals(obj);
	}
	public void copyEventEntityToRepsonse(Events event, boolean isRegistered) {
		this.setId(event.getId());
		this.setName(event.getName());
		this.setStartDate(event.getStartDate());
		this.setEndDate(event.getEndDate());
		this.setStatus(event.getStatus());
		this.setRegistered(isRegistered);
	}
}
