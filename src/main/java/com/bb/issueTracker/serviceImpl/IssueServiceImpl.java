package com.bb.issueTracker.serviceImpl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bb.issueTracker.dto.IssueDto;
import com.bb.issueTracker.dto.ResponseDto;
import com.bb.issueTracker.entity.Department;
import com.bb.issueTracker.entity.Issue;
import com.bb.issueTracker.entity.User;
import com.bb.issueTracker.repository.DepartmentRepository;
import com.bb.issueTracker.repository.IssueRepository;
import com.bb.issueTracker.repository.UserRepository;
import com.bb.issueTracker.service.IssueService;

@Service
public class IssueServiceImpl implements IssueService {
	
	@Autowired
	public IssueRepository issueRepo;
	
	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	public DepartmentRepository departmentRepo;
	
	
	User user = new User();
	Department department=  new Department();
	ResponseDto responseDto = new ResponseDto();
	

	
//	save Issue
public ResponseDto saveIssueDetails(IssueDto issueDto) {
	
	Optional<User> optionalUser= userRepo.findById(issueDto.getUserId());
	if (optionalUser.isPresent()) {
		user = optionalUser.get();
	}
	Optional<Department> optionalDepartment=departmentRepo.findById(issueDto.getDepartmentId());
	if (optionalDepartment.isPresent()) {
		department = optionalDepartment.get();
	}
	LocalDate date = LocalDate.now();
	Issue issue = new Issue();
	issue.setUser(user);
	issue.setDepartment(department);
	issue.setCreatedOn(date);
	issue.setCreatedBy(user.getName());
	issue.setIssue(issueDto.getIssue());
	issue.setStatus(issueDto.getStatus());
	issue.setActive(true);
	issueRepo.save(issue);
	
	responseDto.setId(issue.getId());
	responseDto.setName(user.getName());
	responseDto.setMessage("Issue Successfully Saved");
	
	return responseDto;
}
}
