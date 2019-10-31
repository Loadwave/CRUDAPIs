package com.loadwave.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loadwave.project.exception.ResourceNotFoundException;
import com.loadwave.project.model.Account;
import com.loadwave.project.model.Project;
import com.loadwave.project.repository.AccountRepository;
import com.loadwave.project.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private AccountRepository accountRepository;





	//creating project by AccountID
	public Project createProject(Long account_Id, Project project) {
		return accountRepository.findById(account_Id).map(account -> {
			project.setAccount(account);
			return projectRepository.save(project);
		}).orElseThrow(() -> new ResourceNotFoundException("AccountId " + account_Id + " not found"));
	}



	//get all projects by Account
	public Page<Project> getAllProjectsByAccountId(Account account, Pageable pageable) {

		return projectRepository.findByAccount(account,pageable);
	}



	/*
	 * //get all projects by AccountID public List<Project>
	 * getAllProjectsByAccountId(Long account_Id) { Account
	 * account=accountRepository.getOne(account_Id);
	 * 
	 * return projectRepository.findAll(); }
	 */



	//get  all projects
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	/*
	 * public Optional<Project> getProjectById(Long id) { return
	 * projectRepository.findById(id);
	 * 
	 * }
	 */


	//get project by ProjectId
	public Project getProjectById(Long id) {
		Optional<Project> project = projectRepository.findById(id);
		return project.orElseThrow(() -> new RuntimeException("couldn't find user with id" + id));
	}




	public Project getProjectByAccountId(Account account, Long projectId) {

		return null;
	}



	public Project getProjectById(Long account_Id,Long id) {
		Optional<Project> project = projectRepository.findById(id);
		return project.orElseThrow(() -> new RuntimeException("couldn't find user with id" + id));
	}

	public ResponseEntity<?> deleteProject(Long id) {
		return projectRepository.findById(id).map(post -> {
			projectRepository.delete(post);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("id " + id + " not found"));
	}

	public Project updateProject(Long id, Project projectRequest) {
		return projectRepository.findById(id).map(project -> {
			project.setProjectName(projectRequest.getProjectName());
			project.setDecs(projectRequest.getDecs());
			return projectRepository.save(project);
		}).orElseThrow(() -> new ResourceNotFoundException("ProjectId " + id + " not found"));
	}











}
