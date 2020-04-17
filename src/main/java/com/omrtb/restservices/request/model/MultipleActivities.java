package com.omrtb.restservices.request.model;

import java.io.Serializable;
import java.util.List;

public class MultipleActivities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ReqActivity> reqActivities;

	public List<ReqActivity> getReqActivities() {
		return reqActivities;
	}

	public void setReqActivities(List<ReqActivity> reqActivities) {
		this.reqActivities = reqActivities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
