package com.bb.issueTracker.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bb.issueTracker.dto.ResponseDto;
import com.bb.issueTracker.dto.RoleDto;
import com.bb.issueTracker.entity.Role;
import com.bb.issueTracker.repository.RoleRepository;
import com.bb.issueTracker.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	public RoleRepository roleRepo;
	
	Role role = new Role();
	ResponseDto responseDto = new ResponseDto();
	RoleDto roleDto = new RoleDto();
	

//	List all role
	public List<Role> getAllRoles() {
		return roleRepo.findAll();

	}
	
//	detele role
	public ResponseDto deleteRole(int id) {

		Optional<Role> optional = roleRepo.findById(id);
		if (optional.isPresent()) {
			role = optional.get();
			role.setActive(false);
			roleRepo.save(role); // save role delete details to database
			responseDto.setId(role.getId());
			responseDto.setName(role.getName());
			responseDto.setMessage("Successfully Deleted");
			return responseDto;
		} else {
			responseDto.setMessage("Invalid Id");
			return responseDto;
		}

	}
	
//	get role details by id
	public RoleDto getRoleDetails(int id) {
		Optional<Role> optional = roleRepo.findById(id);
		if (optional.isPresent()) {
			role = optional.get();
			BeanUtils.copyProperties(role, roleDto);
			return roleDto;
		} else {
			responseDto.setMessage("Invalid Id");
			return null;
		}

	}
	
	
//	save Role
public ResponseDto saveRoleDetails(RoleDto roleDto) {

		if (roleDto.getId() != 0) {
			Optional<Role> optional = roleRepo.findById(roleDto.getId());
			if (optional.isPresent()) {
				role = optional.get();
			} else {
				responseDto.setId(role.getId());
				responseDto.setName(role.getName());
				responseDto.setMessage("Invalid Id");
				return responseDto;
			}
		}
		
		role.setId(roleDto.getId());
		role.setName(roleDto.getName());
		role.setActive(true);
		LocalDate date = LocalDate.now();
		if (roleDto.getId() == 0) {
			role.setCreatedOn(date);
			role.setCreatedBy("admin");
		
		}
		if (roleDto.getId() != 0) {
			role.setModifiedOn(date);
			role.setModifiedBy("admin");
			
		}
		roleRepo.save(role);
		responseDto.setId(role.getId());
		responseDto.setName(role.getName());
		responseDto.setMessage("Successfully Saved");
		return responseDto;
	}
	


}
