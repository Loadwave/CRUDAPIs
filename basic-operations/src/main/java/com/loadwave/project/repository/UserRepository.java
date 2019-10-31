package com.loadwave.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loadwave.project.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//public User findByUser_Name(String  user_Name);

}
