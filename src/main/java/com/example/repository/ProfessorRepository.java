package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
