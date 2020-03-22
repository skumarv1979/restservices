package com.omrtb.restservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.omrtb.restservices.entity.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long> {

	//@Query("SELECT a FROM Activity a JOIN a.User u WHERE u.id=?1")
    //List<Activity> listUserActivities(Long id);
	@Query("SELECT a FROM Activity a JOIN a.user u WHERE u.id=?1 order by a.startDate desc")
	List<Activity> listUserActivities(Long id);
}
