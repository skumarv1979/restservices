package com.omrtb.restservices.events;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.omrtb.restservices.entity.model.Role;
import com.omrtb.restservices.repository.RoleRepository;
import com.omrtb.restservices.utils.RoleSingleton;

@Component
public class AppEvents {
	
	@Autowired
	private RoleRepository roleRepository;
	
	private static Logger LOGGER = LogManager.getLogger(AppEvents.class);

    //@EventListener(ApplicationContextInitializedEvent.class)
	//@EventListener(ApplicationEvent.class)
	@EventListener(ApplicationReadyEvent.class)
    public void startApp() {
    	//stravaUtils.authorizeStravaUsers();
		LOGGER.info("Do any start up tasks here");
		RoleSingleton roleSingleton = RoleSingleton.getInstance(roleRepository);
		//roleSingleton.initializeRoles(roleRepository);
		Map<String, Role> roleMap = roleSingleton.getRoleMap();
		for (Map.Entry<String,Role> roleEntrySet : roleMap.entrySet()) {
			String key = roleEntrySet.getKey();
			Role role = roleEntrySet.getValue();
			LOGGER.error("Role :: "+key +", noof users :: "+role.getUsers().size());
		}
		//LOGGER.error("role maps :: "+roleSingleton.getRoleMap());
    }
}
