package com.loadwave.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.loadwave.project.exception.ResourceNotFoundException;
import com.loadwave.project.model.Project;
import com.loadwave.project.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired 
	private ProjectRepository projectRepository;


	public Project createProject(Project project) {
		return projectRepository.save(project);
	}

	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}

	public Optional<Project> getProjectById(Long id) {
		return projectRepository.findById(id);

	}


	public ResponseEntity<?> deleteProject(Long id) {
		return projectRepository.findById(id).map(post -> {
			projectRepository.delete(post);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("id " + id + " not found"));
	}


	public Project updateProject(Long id,Project projectRequest) {
		return projectRepository.findById(id).map(project -> {
			project.setProjectName(projectRequest.getProjectName());
			project.setDecs(projectRequest.getDecs());
			return projectRepository.save(project);
		}).orElseThrow(() -> new ResourceNotFoundException("ProjectId " + id + " not found"));
	}



}
