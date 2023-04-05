package com.bb.issueTracker.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Where(clause="active=1")
@Table(name="issue")
public class Issue implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; // for join table

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department; // for join table
	
	@Column(name = "createdOn")
	private LocalDate createdOn;
	
	@Column(name = "createdBy")
	private String createdBy;
	
	@Column(name = "modifiedOn")
	private LocalDate modifiedOn;
	
	@Column(name = "modifiedBy")
	private String modifiedBy;
	
	@Column(name = "issue")
	private String issue;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "active")
	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Issue(int id, User user, Department department, LocalDate createdOn, String createdBy, LocalDate modifiedOn,
			String modifiedBy, String issue, String status, boolean active) {
		super();
		this.id = id;
		this.user = user;
		this.department = department;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.issue = issue;
		this.status = status;
		this.active = active;
	}

	public Issue() {
		super();
	}
	
	

}
