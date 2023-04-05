package com.bb.issueTracker.service;

import com.bb.issueTracker.dto.IssueDto;
import com.bb.issueTracker.dto.ResponseDto;

public interface IssueService {
	public ResponseDto saveIssueDetails(IssueDto issueDto);

}
