package com.loadwave.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.loadwave.project.exception.ResourceNotFoundException;
import com.loadwave.project.model.Test;
import com.loadwave.project.model.User;
import com.loadwave.project.repository.AccountRepository;
import com.loadwave.project.repository.RoleRepository;
import com.loadwave.project.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
     
	@Autowired
	private AccountRepository accountRepository;


	/*
	 * public void save(User user,Account account) { user.setAccount(account);
	 * //user.setRoles(new HashSet<>(roleRepository.findAll()));
	 * userRepository.save(user); }
	 */
	
	
	
	
	/*public Test createTest(Long projectId, Test test) {
		return projectRepository.findById(projectId).map(project -> {
			test.setProject(project); // injecting project to test
			return testRepository.save(test);
		}).orElseThrow(() -> new ResourceNotFoundException("ProjectId " + projectId + " not found"));
	}
*/

    // create user by account id
	public User createUser(Long account_Id, User user) {
		return accountRepository.findById(account_Id).map(account -> {
			user.setAccount(account);
			return userRepository.save(user);
		}).orElseThrow(() -> new ResourceNotFoundException("AccountId " + account_Id + " not found"));
	}
}
