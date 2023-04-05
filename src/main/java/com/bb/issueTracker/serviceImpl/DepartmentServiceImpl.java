package com.bb.issueTracker.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bb.issueTracker.dto.DepartmentDto;
import com.bb.issueTracker.dto.ResponseDto;
import com.bb.issueTracker.entity.Department;
import com.bb.issueTracker.repository.DepartmentRepository;
import com.bb.issueTracker.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	public DepartmentRepository deptRepo;
	
	Department department = new Department();
	ResponseDto responseDto = new ResponseDto();
	DepartmentDto departmentDto = new DepartmentDto();
	

//	List all department
	public List<Department> getAllDepartments() {
		return deptRepo.findAll();

	}
	
//	detele department
	public ResponseDto deleteDepartment(int id) {

		Optional<Department> optional = deptRepo.findById(id);
		if (optional.isPresent()) {
			department = optional.get();
			department.setActive(false);
			deptRepo.save(department); // save department delete details to database
			responseDto.setId(department.getId());
			responseDto.setName(department.getName());
			responseDto.setMessage("Successfully Deleted");
			return responseDto;
		} else {
			responseDto.setMessage("Invalid Id");
			return responseDto;
		}

	}
	
//	get department details by id
	public DepartmentDto getDepartmentDetails(int id) {
		Optional<Department> optional = deptRepo.findById(id);
		if (optional.isPresent()) {
			department = optional.get();
			BeanUtils.copyProperties(department, departmentDto);
			return departmentDto;
		} else {
			responseDto.setMessage("Invalid Id");
			return null;
		}

	}
	
	public ResponseDto saveDepartmentDetails(DepartmentDto departmentDto) {

		

		if (departmentDto.getId() != 0) {
			Optional<Department> optional = deptRepo.findById(departmentDto.getId());
			if (optional.isPresent()) {
				department = optional.get();
			} else {
				responseDto.setId(department.getId());
				responseDto.setName(department.getName());
				responseDto.setMessage("Invalid Id");
				return responseDto;
			}
		}
		
		department.setId(departmentDto.getId());
		department.setName(departmentDto.getName());
		department.setActive(true);
		LocalDate date = LocalDate.now();
		if (departmentDto.getId() == 0) {
			department.setCreatedOn(date);
			department.setCreatedBy("admin");
		
		}
		if (departmentDto.getId() != 0) {
			department.setModifiedOn(date);
			department.setModifiedBy("admin");
			
		}
		deptRepo.save(department);
		responseDto.setId(department.getId());
		responseDto.setName(department.getName());
		responseDto.setMessage("Successfully Saved");
		return responseDto;
	}


}
