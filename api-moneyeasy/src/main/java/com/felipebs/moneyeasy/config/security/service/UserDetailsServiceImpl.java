package com.felipebs.moneyeasy.config.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipebs.moneyeasy.config.security.model.UserDetailsImpl;
import com.felipebs.moneyeasy.config.security.model.UserModel;
import com.felipebs.moneyeasy.config.security.repository.IUserRepository;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	     UserModel user = userRepository.findByUsername(username);
	     
	     if(user == null) throw new UsernameNotFoundException("Could not find this user!");
	     return UserDetailsImpl.build(user);
	}
	
}
