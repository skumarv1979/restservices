package com.omrtb.restservices.entity.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Data;

@Entity
@Data
@Access(value=AccessType.FIELD)
public class RegisteredUsersUseless implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long registrationId;
	
	private String attendeeName;
	
	private String attendeeEmail;
	
	private String contactNumber;
	
	private Date registrationTime;
	
	private String gender;
	
	private String omrtb;
	
	private String purchaserName;
	
	private String purchaserEmail;
	
	private int emailModified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public String getAttendeeName() {
		return attendeeName;
	}

	public void setAttendeeName(String attendeeName) {
		this.attendeeName = attendeeName;
	}

	public String getAttendeeEmail() {
		return attendeeEmail;
	}

	public void setAttendeeEmail(String attendeeEmail) {
		this.attendeeEmail = attendeeEmail;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOmrtb() {
		return omrtb;
	}

	public void setOmrtb(String omrtb) {
		this.omrtb = omrtb;
	}

	public String getPurchaserName() {
		return purchaserName;
	}

	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
	}

	public String getPurchaserEmail() {
		return purchaserEmail;
	}

	public void setPurchaserEmail(String purchaserEmail) {
		this.purchaserEmail = purchaserEmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getEmailModified() {
		return emailModified;
	}

	public void setEmailModified(int emailModified) {
		this.emailModified = emailModified;
	}

	@PrePersist
	public void prePersist() {
		emailModified = 0;
	}
	@Override
	public String toString() {
		return "RegisteredUsersUseless [id=" + id + ", registrationId=" + registrationId + ", attendeeName="
				+ attendeeName + ", attendeeEmail=" + attendeeEmail + ", contactNumber=" + contactNumber
				+ ", registrationTime=" + registrationTime + ", gender=" + gender + ", omrtb=" + omrtb
				+ ", purchaserName=" + purchaserName + ", purchaserEmail=" + purchaserEmail + ", emailModified="+emailModified+"]";
	}
	
	
}
