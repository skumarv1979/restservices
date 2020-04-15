package com.omrtb.restservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.omrtb.restservices.entity.model.Events;

@RepositoryRestResource
public interface EventsRepository extends CrudRepository<Events, Long> {

    @Query("FROM Events WHERE status = 'Open' order by start_date desc")
    List<Events> findAllOpenEvents();

    @Query("FROM Events e left join e.userEventsRegistration u WHERE e.status = 'Open' order by start_date desc")
    List<Events> findAllOpenEventsOfUser(Long id);

    @Query("FROM Events WHERE name = ?1 and status='Open' order by start_date desc")
    List<Events> findByName(String name);
}
