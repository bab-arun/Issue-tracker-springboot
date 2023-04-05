package com.bb.issueTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.issueTracker.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Integer> {

}
