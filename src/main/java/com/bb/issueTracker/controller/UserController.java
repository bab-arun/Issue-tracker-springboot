package com.bb.issueTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bb.issueTracker.dto.ResponseDto;
import com.bb.issueTracker.dto.UserDto;
import com.bb.issueTracker.entity.User;
import com.bb.issueTracker.service.UserService;

@RestController
public class UserController {
	@Autowired
	public UserService userService;
	
	@GetMapping("/user/showAll")
	public List<User> findAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/delete/{id}")
	public ResponseDto deleteUserDetails(@PathVariable("id") int id) {
		return userService.deleteUser(id);
		
	}
	
	@GetMapping("/user/get/{id}")
	public UserDto getUser(@PathVariable("id") int id) {
		return userService.getUserDetails(id);
	}
	
	@PostMapping("/user/save")
	public ResponseDto  saveUser(@RequestBody UserDto userDto) {
	return userService.saveUserDetails(userDto);
	}
	
//	@PostMapping("/login/check")
//	public UserDto checkUser(@RequestBody UserDto userDto) {
//		return userService.checkUser(userDto);
//	}
//	

}
