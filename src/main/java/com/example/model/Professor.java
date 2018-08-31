package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Professor extends User implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "siape")
	private String sieape;
	
	@OneToMany(mappedBy ="professor", cascade = CascadeType.ALL)
	List<Module> modules;

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}

	public String getSieape() {return sieape;}
	public void setSieape(String sieape) {this.sieape = sieape;}

	public List<Module> getModules() {return modules;}
	public void setModules(List<Module> modules) {this.modules = modules;}
	
}
