package com.omrtb.restservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.omrtb.restservices.entity.model.RegisteredUsersUseless;

@RepositoryRestResource
public interface RegisteredUsersUselessRepository extends CrudRepository<RegisteredUsersUseless, Long> {
    @Query("FROM RegisteredUsersUseless r where r.attendeeEmail not in (SELECT u.email FROM User u WHERE u.email = r.attendeeEmail)")
    List<RegisteredUsersUseless> unRegisteredUsers();

    @Query("FROM RegisteredUsersUseless")
    List<RegisteredUsersUseless> getAllUsers();

}