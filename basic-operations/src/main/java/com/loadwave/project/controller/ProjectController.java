package com.loadwave.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loadwave.project.model.Account;
import com.loadwave.project.model.Project;
import com.loadwave.project.service.AccountService;
import com.loadwave.project.service.ProjectService;

@RestController
//@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService ;


	@Autowired
	AccountService accountService;




	//create Project by AccountId
	@PostMapping("/accounts/{account_Id}/createproject")
	public Project createProject(@PathVariable Long account_Id ,@RequestBody Project project) {
		return projectService.createProject(account_Id, project);
	}



	/*
	 * get all projects 
	 * @GetMapping("/all") public List<Project> getAllProject(){ return
	 * projectService.getAllProjects();
	 * 
	 * }
	 */

	//get all projects by AccountId
	@GetMapping("/accounts/{account_Id}/projects")
	public Page<Project> getAllProjectsByAccountId(@PathVariable Long account_Id,Pageable pageable)
	{ 
		Account account =accountService.getAccountById(account_Id);
		return projectService.getAllProjectsByAccountId(account,pageable);
	}


	/*  get project by ProjectId
	 * @GetMapping("/get/{id}") public Project getProjectById(@PathVariable Long
	 * id){ return projectService.getProjectById(id); }
	 */

	//get project  by  accountId,projectId
	@GetMapping("accounts/{account_Id}/projects/{projectId}")
	public Project getProjectByAccountId(@PathVariable Long  account_Id,@PathVariable Long projectId) {
		Account account =accountService.getAccountById(account_Id);   //getting account
		return projectService.getProjectByAccountId(account,projectId);       //getting projects by Account
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable Long id) {
		return projectService.deleteProject(id);

	}

	@PutMapping("/update/{id}")
	public Project updateProject(@PathVariable Long id,@RequestBody Project projectRequest) {
		return projectService.updateProject(id, projectRequest);
	}



}


