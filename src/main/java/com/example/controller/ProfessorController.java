package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Professor;
import com.example.service.ProfessorService;

@Controller
@RequestMapping("/professors")
public class ProfessorController {
	
	private static final String MSG_SUCESS_INSERT = "Student inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Student successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Student successfully.";
	private static final String MSG_ERROR = "Error.";
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping
	public String index(Model model) {
		List<Professor> all = professorService.findAll();
		model.addAttribute("listProfessor", all);
		return "professor/index";
	}
	
	@GetMapping(value="/new")
	public String create(Model model, @ModelAttribute Professor professorEntity) {
		model.addAttribute("professor", professorEntity);
		return "professor/form";
	}
	
	@GetMapping(value="/{id}")
	public String show (Model model, @PathVariable("id") Integer id) {
		if(id != null) {
			Professor professor = professorService.findOne(id).get();
			model.addAttribute("professor", professor);
		}
		return "professor/show";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Professor entityProfessor, BindingResult result, RedirectAttributes redirectAttributes) {
		Professor professor = null;
		try {
			professor.setPassword(encoder.encode(professor.getPassword()));
			professor = professorService.save(entityProfessor);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/professors/" + professor.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Professor entity = professorService.findOne(id).get();
				model.addAttribute("professor", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "professor/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Professor entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Professor professor = null;
		try {
			professor = professorService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/professors/" + professor.getId();
	}
	
	@RequestMapping(value="/{id}/delete")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if(id != null) {
				Professor professor = professorService.findOne(id).get();
				professorService.delete(professor);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
			
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/professors/";
	}
	
	
}
