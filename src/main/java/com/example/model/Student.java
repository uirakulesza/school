package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "registration")
	private String registration;
	
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module module;

	public void setRegistration(String registration) {this.registration = registration;}
	public String getRegistration() {return registration;}

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}

	public Module getModule() {return module;}
	public void setModule(Module module) {this.module = module;}

}