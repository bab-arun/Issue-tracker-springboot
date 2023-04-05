package com.bb.issueTracker.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Where(clause="active=1")
@Table(name="role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "createdOn")
	private LocalDate createdOn;
	
	@Column(name = "createdBy")
	private String createdBy;
	
	@Column(name = "modifiedOn")
	private LocalDate modifiedOn;
	
	@Column(name = "modifiedBy")
	private String modifiedBy;
	
	@Column(name = "active")
	private boolean active;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<UserDepartment> userDepartment;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate date) {
		this.createdOn = date;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDate modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public List<UserDepartment> getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(List<UserDepartment> userDepartment) {
		this.userDepartment = userDepartment;
	}
	
	

	public Role(int id, String name, LocalDate createdOn, String createdBy, LocalDate modifiedOn, String modifiedBy,
			boolean active, List<UserDepartment> userDepartment) {
		super();
		this.id = id;
		this.name = name;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.active = active;
		this.userDepartment = userDepartment;
	}

	public Role() {
		super();
	}
	
	
	
}
