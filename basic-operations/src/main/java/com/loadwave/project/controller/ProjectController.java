package com.loadwave.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loadwave.project.model.Project;
import com.loadwave.project.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService ;

	@PostMapping("/create")
	public Project createProject(@RequestBody Project project) {
		return projectService.createProject(project);	
	}

	@GetMapping("/all")
	public List<Project> getAllProject(){
		return projectService.getAllProjects();

	}

	@GetMapping("/get/{id}")
	public Optional<Project> getProjectById(@PathVariable Long id){
		return projectService.getProjectById(id);
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


