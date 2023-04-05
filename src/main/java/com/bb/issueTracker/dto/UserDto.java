package com.bb.issueTracker.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;
	private String name;
	private long mobile;
	private String email;
	private String password;
	private String address;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;
	private int deptId;
	private int roleId;
	private String deptName;
	private String roleName;
	private boolean active;
	private List<UserDepartmentDto> userDepartment;
	
	
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	public List<UserDepartmentDto> getUserDepartment() {
		return userDepartment;
	}
	public void setUserDepartment(List<UserDepartmentDto> userDepartment) {
		this.userDepartment = userDepartment;
	}
	public UserDto() {
		super();
	}
	public UserDto(int id, String name, long mobile, String email, String password, String address, Date createdOn,
			String createdBy, Date modifiedOn, String modifiedBy, int deptId, int roleId, String deptName,
			String roleName, boolean active, List<UserDepartmentDto> userDepartment) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.address = address;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.deptId = deptId;
		this.roleId = roleId;
		this.deptName = deptName;
		this.roleName = roleName;
		this.active = active;
		this.userDepartment = userDepartment;
	}
	
	
	
	
	
	
	
	

}
