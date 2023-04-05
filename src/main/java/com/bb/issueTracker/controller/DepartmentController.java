package com.bb.issueTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bb.issueTracker.dto.DepartmentDto;
import com.bb.issueTracker.dto.ResponseDto;
import com.bb.issueTracker.entity.Department;
import com.bb.issueTracker.service.DepartmentService;


@RestController
public class DepartmentController {

	@Autowired
	public DepartmentService departmentService;
	
	
	
	@GetMapping("/department/showAll")
	public List<Department> findAllDepartmenyts() {
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/department/delete/{id}")
	public ResponseDto deleteDeptDetails(@PathVariable("id") int id) {
		return departmentService.deleteDepartment(id);
		
	}
	
	@GetMapping("/department/get/{id}")
	public DepartmentDto getDepartment(@PathVariable("id") int id) {
		return departmentService.getDepartmentDetails(id);
	}
	
	@PostMapping("/department/save")
	public ResponseDto  saveDepartment(@RequestBody DepartmentDto departmentDto) {
	return departmentService.saveDepartmentDetails(departmentDto);
	}

}
