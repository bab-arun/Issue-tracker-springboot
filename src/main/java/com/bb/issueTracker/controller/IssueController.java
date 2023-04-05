package com.bb.issueTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bb.issueTracker.dto.IssueDto;
import com.bb.issueTracker.dto.ResponseDto;
import com.bb.issueTracker.dto.RoleDto;
import com.bb.issueTracker.service.IssueService;


@RestController
public class IssueController {
	
	@Autowired
	public IssueService issueService;
	
	@PostMapping("/save/issue")
	public ResponseDto  saveIssue(@RequestBody IssueDto issueDto) {
		return issueService.saveIssueDetails(issueDto);
		}
}
