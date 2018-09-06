package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
@Transactional(readOnly=true)
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll (){
		return userRepository.findAll();
	}
	
	public Optional<User> findOne(Integer id) {
		return userRepository.findById(id);
	}
	
	public User save(User entity) {
		return userRepository.save(entity);
	}
	
	public void delete(User entity) {
		 userRepository.delete(entity);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
