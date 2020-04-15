package com.omrtb.restservices.entity.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserEventsRegistrationId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "users_id")
	private Long usersId;
	
	@Column(name = "events_id")
	private Long eventsId;
	
	public UserEventsRegistrationId() {
	}
	
	public UserEventsRegistrationId(Long usersId, Long eventsId) {
		this.usersId = usersId;
		this.eventsId = eventsId;
	}

	public Long getUsersId() {
		return usersId;
	}

	public void setUsersId(Long usersId) {
		this.usersId = usersId;
	}

	public Long getEventsId() {
		return eventsId;
	}

	public void setEventsId(Long eventsId) {
		this.eventsId = eventsId;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        UserEventsRegistrationId that = (UserEventsRegistrationId) o;
        return Objects.equals(usersId, that.usersId) &&
               Objects.equals(eventsId, that.eventsId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(usersId, eventsId);
    }
	
}
