package com.felipebs.moneyeasy.config.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.felipebs.moneyeasy.config.security.model.UserDetailsImpl;
import com.felipebs.moneyeasy.config.security.repository.IUserRepository;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    return UserDetailsImpl.build(userRepository.findByUsername(username));
	}

}
