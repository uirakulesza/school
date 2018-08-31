package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Professor;
import com.example.repository.ProfessorRepository;

@Service
@Transactional(readOnly = true)
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> findAll(){
		return professorRepository.findAll();
	}
	
	public Optional<Professor> findOne(Integer id) {
		return professorRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Professor save(Professor entity) {
		return professorRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Professor entity) {
		professorRepository.delete(entity);
	}

}
