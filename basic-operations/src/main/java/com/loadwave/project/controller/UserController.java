package com.loadwave.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loadwave.project.model.User;
import com.loadwave.project.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/accounts/{account_Id}/createUser")
	public User createUser(@PathVariable Long account_Id,@RequestBody User user) {
		return userService.createUser(account_Id, user) ;

	}
	  

}
