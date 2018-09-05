package com.example.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="role")
public class Role implements GrantedAuthority, Persistable<Integer>{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
	
	@Column(name="identifier")
	private String identifier;
	
	@Column(name="name")
	private String name;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id;
    }
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public String getAuthority() {
		return identifier;
	}
	
	@Override
	public boolean isNew() {
		return id == 0;
	}

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}

	public String getIdentifier() { return identifier;}
	public void setIdentifier(String identifier) {this.identifier = identifier;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	
	
}
