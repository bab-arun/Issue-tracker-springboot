package com.bb.issueTracker.service;

import java.util.List;

import com.bb.issueTracker.dto.ResponseDto;
import com.bb.issueTracker.dto.UserDto;
import com.bb.issueTracker.entity.User;


public interface UserService {

	public List<User> getAllUsers();
	public ResponseDto deleteUser(int id);
	public UserDto getUserDetails(int id);
	public ResponseDto saveUserDetails(UserDto userDto);
//	public UserDto checkUser(UserDto userDto);

}
