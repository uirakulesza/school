package com.example.repository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {
	//Page<Module> findByStudentId(Integer studentId, Pageable pageable);
}