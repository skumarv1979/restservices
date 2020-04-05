package com.omrtb.restservices.utils;

import java.util.HashMap;
import java.util.Map;

import com.omrtb.restservices.entity.model.Role;
import com.omrtb.restservices.repository.RoleRepository;

public class RoleSingleton {

	private static RoleSingleton instance = null;
	
	private static final Map<String, Role> map = new HashMap<String, Role>();
	
	private RoleSingleton() {
	}
	
    public static RoleSingleton getInstance(RoleRepository roleRepository) { 
        if (instance == null) {
        	synchronized (RoleSingleton.class) {
        		if(instance==null) {
        			instance = new RoleSingleton();
        			//instance.initializeRoles(roleRepository);
        			Iterable<Role> rolesItr = roleRepository.findWithoutNPlusOne();
        			if(rolesItr!=null) {
        				for (Role role : rolesItr) {
        					map.put(role.getName(), role);
        				}
        			}
        		}
        	}
        }
        return instance;
    }
    
    public static void initializeRoles(RoleRepository roleRepository) {
		Iterable<Role> rolesItr = roleRepository.findWithoutNPlusOne();
		if(rolesItr!=null) {
			for (Role role : rolesItr) {
				map.put(role.getName(), role);
			}
		}
    }
    
    public Role getRole(String name) {
		return map.get(name);
	}
    public Map<String, Role> getRoleMap() {
		return map;
	}
}
