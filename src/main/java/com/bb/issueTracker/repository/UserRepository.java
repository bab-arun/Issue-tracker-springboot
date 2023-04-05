package com.bb.issueTracker.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bb.issueTracker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(" FROM User  WHERE email = :email")
	public User findByEmail(String email);

}
