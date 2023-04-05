package com.bb.issueTracker.service;

import java.util.List;
import com.bb.issueTracker.dto.ResponseDto;
import com.bb.issueTracker.dto.RoleDto;
import com.bb.issueTracker.entity.Role;

public interface RoleService {
	public List<Role> getAllRoles();
	public ResponseDto deleteRole(int id);
	public RoleDto getRoleDetails(int id);
	public ResponseDto saveRoleDetails(RoleDto roleDto);

}
