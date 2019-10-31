package com.deloitte.forecastsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.forecastsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
}
