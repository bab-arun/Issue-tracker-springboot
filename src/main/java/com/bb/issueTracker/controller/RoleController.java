package com.bb.issueTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bb.issueTracker.dto.ResponseDto;
import com.bb.issueTracker.dto.RoleDto;
import com.bb.issueTracker.entity.Role;
import com.bb.issueTracker.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	public RoleService roleService;

	@GetMapping("/role/showAll")
	public List<Role> findAllRoles() {
		return roleService.getAllRoles();
	}
	
	@GetMapping("/role/delete/{id}")
	public ResponseDto deleteRoleDetails(@PathVariable("id") int id) {
		return roleService.deleteRole(id);
		
	}
	
	@GetMapping("/role/get/{id}")
	public RoleDto getRole(@PathVariable("id") int id) {
		return roleService.getRoleDetails(id);
	}
	
	@PostMapping("/role/save")
	public ResponseDto  saveRole(@RequestBody RoleDto roleDto) {
	return roleService.saveRoleDetails(roleDto);
	}
}
