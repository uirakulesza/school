package com.example.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.model.User;
import com.example.repository.UserRepository;

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User entity = userRepository.findByUsername(username);
		
		if(entity == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		return new org.springframework.security.core.userdetails.User(entity.getUsername(), entity.getPassword(), entity.getRoles());
	}

	

}
