package com.bb.issueTracker.service;

import java.util.List;

import com.bb.issueTracker.dto.DepartmentDto;
import com.bb.issueTracker.dto.ResponseDto;
import com.bb.issueTracker.entity.Department;


public interface DepartmentService {
	
	public List<Department> getAllDepartments();
	public ResponseDto deleteDepartment(int id);
	public DepartmentDto getDepartmentDetails(int id);
	public ResponseDto saveDepartmentDetails(DepartmentDto departmentDto);
}
