package com.bb.issueTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bb.issueTracker.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
