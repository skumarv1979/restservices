package com.omrtb.restservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.omrtb.restservices.entity.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
    @Query("SELECT r FROM Role r LEFT JOIN FETCH r.users")
    List<Role> findWithoutNPlusOne();
    
}
