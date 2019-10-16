package com.loadwave.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loadwave.project.exception.ResourceNotFoundException;
import com.loadwave.project.model.Test;
import com.loadwave.project.repository.ProjectRepository;
import com.loadwave.project.repository.TestRepository;

@Service
public class TestService {
	@Autowired
	private TestRepository testRepository ;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	/*get All tests by project id*/
	/*
	 * public List<Test> getAllTestsByProjectId(Long id){ return
	 * testRepository.findByProjectId(id); }
	 */
	
	
	/* creating test */
	public Test createTest(Long projectId,Test test) {
		 return projectRepository.findById(projectId).map(project -> {
			 test.setProject(project);
	            return testRepository.save(test);
	        }).orElseThrow(() -> new ResourceNotFoundException("ProjectId " + projectId + " not found"));
		
		
	}
	
	
	
	
	

}
