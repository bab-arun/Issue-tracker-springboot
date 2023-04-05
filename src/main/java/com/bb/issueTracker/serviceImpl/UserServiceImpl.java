package com.bb.issueTracker.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bb.issueTracker.dto.ResponseDto;
import com.bb.issueTracker.dto.UserDepartmentDto;
import com.bb.issueTracker.dto.UserDto;
import com.bb.issueTracker.entity.Department;
import com.bb.issueTracker.entity.Role;
import com.bb.issueTracker.entity.User;
import com.bb.issueTracker.entity.UserDepartment;
import com.bb.issueTracker.repository.DepartmentRepository;
import com.bb.issueTracker.repository.RoleRepository;
import com.bb.issueTracker.repository.UserDepartmentRepository;
import com.bb.issueTracker.repository.UserRepository;
import com.bb.issueTracker.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepo;

	@Autowired
	public DepartmentRepository deptRepo;

	@Autowired
	public RoleRepository roleRepo;

	@Autowired
	public UserDepartmentRepository userDeptRepo;

	UserDto userDto = new UserDto();
	User user = new User();
	Department department = new Department();
	Role role = new Role();
	UserDepartment userDept = new UserDepartment();
	ResponseDto responseDto = new ResponseDto();

//	List all user
	public List<User> getAllUsers() {
		return userRepo.findAll();

	}

//	detele user
	public ResponseDto deleteUser(int id) {

		Optional<User> optional = userRepo.findById(id);
		if (optional.isPresent()) {
			user = optional.get();
			user.setActive(false);
			userRepo.save(user); // save user details to database
			responseDto.setId(user.getId());
			responseDto.setName(user.getName());
			responseDto.setMessage("Successfully Deleted");
			return responseDto;
		} else {
			responseDto.setMessage("Invalid Id");
			return responseDto;
		}

	}

//	get user details by id
	public UserDto getUserDetails(int id) {
		Optional<User> optional = userRepo.findById(id);
		if (optional.isPresent()) {
			user = optional.get();
			BeanUtils.copyProperties(user, userDto);
			return userDto;
		} else {
			responseDto.setMessage("Invalid Id");
			return null;
		}

	}

	public ResponseDto saveUserDetails(UserDto userDto) {

		if (userDto.getId() != 0) {
			Optional<User> optional = userRepo.findById(userDto.getId());
			if (optional.isPresent()) {
				user = optional.get();

			} else {
				responseDto.setId(user.getId());
				responseDto.setName(user.getName());
				responseDto.setMessage("Invalid Id");
				return responseDto;
			}

		}

		user.setName(userDto.getName());
		user.setMobile(userDto.getMobile());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAddress(userDto.getAddress());
		LocalDate date = LocalDate.now();
		user.setCreatedOn(date);
		user.setCreatedBy("admin");
		user.setModifiedOn(date);
		user.setModifiedBy("admin");
		user.setActive(userDto.getActive());
		user = userRepo.save(user); // user table save

		List<UserDepartmentDto> userdeptList = userDto.getUserDepartment();
		if (userdeptList != null) {
			for (UserDepartmentDto userDep : userdeptList) {

				if (userDep.getId() != 0) {
					Optional<UserDepartment> optional = userDeptRepo.findById(userDep.getId());
					if (optional.isPresent()) {
						UserDepartment optionalUserDept = optional.get();
						Optional<Role> role = roleRepo.findById(userDep.getRoleId());
						Optional<Department> dept = deptRepo.findById(userDep.getDepartmentId());
						optionalUserDept.setUser(user);
						optionalUserDept.setRole(role);
						optionalUserDept.setDepartment(dept);
						optionalUserDept.setCreatedOn(date);
						optionalUserDept.setCreatedBy("admin");
						optionalUserDept.setActive(true);
						userDeptRepo.save(optionalUserDept);
					}
				} else {
					UserDepartment userDept = new UserDepartment();
					userDept.setUser(user);
					Optional<Role> role = roleRepo.findById(userDep.getRoleId());
					Optional<Department> dept = deptRepo.findById(userDep.getDepartmentId());
					userDept.setRole(role);
					userDept.setDepartment(dept);
					userDept.setCreatedOn(date);
					userDept.setCreatedBy("admin");
					userDept.setActive(true);
					userDeptRepo.save(userDept);
				}

			}
		}

		responseDto.setId(user.getId());
		responseDto.setName(user.getName());
		responseDto.setMessage("Successfully Saved");
		return responseDto;

	}



}
