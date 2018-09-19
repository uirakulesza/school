package com.example.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.example.model.User;
import com.example.repository.UserRepository;

@Repository
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User entity = userRepository.findByUsername(username);
		
		if(entity == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		return entity;
	}

	

}
