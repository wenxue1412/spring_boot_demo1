package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.domain.TestUser;

@Repository
public interface TestUserDAO extends JpaRepository<TestUser,Integer>{
	
	TestUser findByNameLike(String name);
}
