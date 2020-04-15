package com.omrtb.restservices.entity.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.omrtb.restservices.converter.BooleanToIntegerConverter;

@Entity
@Table(name = "user_events_registration")
public class UserEventsRegistration implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserEventsRegistrationId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("usersId")
	private User users;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("eventsId")
	private Events events;

    @Column(name = "active", columnDefinition = "INT(1)")
    @Convert(converter=BooleanToIntegerConverter.class)
//    @ColumnDefault("true")
    private Boolean active;

    @CreationTimestamp
	@Column(name = "created_on")
	private Date createdOn;

	public UserEventsRegistration() {
	}

	public UserEventsRegistration(User user, Events events) {
		this.users = user;
		this.events = events;
		this.id = new UserEventsRegistrationId(user.getId(), events.getId());
	}

	// Getters and setters omitted for brevity

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		UserEventsRegistration that = (UserEventsRegistration) o;
		return Objects.equals(users, that.users) && Objects.equals(events, that.events);
	}

	public UserEventsRegistrationId getId() {
		return id;
	}

	public void setId(UserEventsRegistrationId id) {
		this.id = id;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@PrePersist
	public void prePersist() {
	    if(active == null)
	    	active = true;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(users, events);
	}

}
