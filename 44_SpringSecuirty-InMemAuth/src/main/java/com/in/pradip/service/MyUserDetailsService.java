package com.in.pradip.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //logic to get user 
		//userRepo.findByUserName(name);
		
		return new User("pradip","pradip@123", Collections.emptyList());
	}

}
