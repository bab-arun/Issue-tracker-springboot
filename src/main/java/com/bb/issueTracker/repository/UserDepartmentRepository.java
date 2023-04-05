package com.bb.issueTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.issueTracker.entity.UserDepartment;

public interface UserDepartmentRepository extends JpaRepository<UserDepartment, Integer>{

}
