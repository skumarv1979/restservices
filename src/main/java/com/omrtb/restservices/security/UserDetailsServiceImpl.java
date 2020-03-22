package com.omrtb.restservices.security;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.omrtb.restservices.controller.PdfUserDetails;
import com.omrtb.restservices.entity.model.User;
import com.omrtb.restservices.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LogManager.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    	Optional<User> optionalUser = userRepository.findUniqueUserByEmail(userId);
    	User user = null;
        if (!optionalUser.isPresent()) {
        	List<User> users = userRepository.findByMobile(userId);
        	if(users==null || users.isEmpty()) {
        		throw new UsernameNotFoundException("User not found.");
        	}
        	else if(users.size()>1) {
        		throw new UsernameNotFoundException("Too many users when matching with Mobile, but no matching with Email");
        	}
        	else {
        		user = users.get(0);
        		Hibernate.initialize(user.getRoles());
        	}
        }
        else {
        	user = optionalUser.get();
    		Hibernate.initialize(user.getRoles());
        }
        /*Optional<User> optionalUser = userRepository.findByUserId(userId);
        User user = null;
        if (!optionalUser.isPresent()) {
        	List<User> users = userRepository.findByMobile(userId);
        	if(users==null || users.isEmpty()) {
        		users = userRepository.findByEmail(userId);
        		if(users==null || users.isEmpty()) {
            		throw new UsernameNotFoundException("User not found.");
        		}
        		else if(users.size()>1) {
            		throw new UsernameNotFoundException("Too many users when matching with Email, but no matching with Mobile");
        		}
        		else {
            		user = users.get(0);
        		}
        	}
        	else if(users.size()>1) {
        		users = userRepository.findByEmail(userId);
        		if(users==null || users.isEmpty()) {
            		throw new UsernameNotFoundException("Too many users when matching with Mobile, but no matching with Email");
        		}
        		else if(users.size()>1) {
            		throw new UsernameNotFoundException("Too many users when matching with Mobile & Email");
        		}
        		else {
            		user = users.get(0);
        		}
        	}
        	else {
        		user = users.get(0);
        	}
        }
        else {
        	user = optionalUser.get();
        }*/
        PdfUserDetails pdfUser = new PdfUserDetails(user);
        log.info("loadUserByUsername() : {}", userId);
        return pdfUser;
    }
}