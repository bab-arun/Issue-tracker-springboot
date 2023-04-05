package com.bb.issueTracker.dto;

import java.time.LocalDate;


public class DepartmentDto {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private LocalDate createdOn;
	private String createdBy;
	private LocalDate modifiedOn;
	private String modifiedBy;
	private boolean active;
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
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
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
	public DepartmentDto(int id, String name, LocalDate createdOn, String createdBy, LocalDate modifiedOn, String modifiedBy,
			boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.active = active;
	}
	public DepartmentDto() {
		super();
	}
	
	
}
