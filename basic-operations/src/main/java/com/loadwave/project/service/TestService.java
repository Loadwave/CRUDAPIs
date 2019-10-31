package com.loadwave.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.loadwave.project.exception.ResourceNotFoundException;
import com.loadwave.project.model.Project;
import com.loadwave.project.model.Test;
import com.loadwave.project.repository.ProjectRepository;
import com.loadwave.project.repository.TestRepository;

@Service
public class TestService {
	@Autowired
	private TestRepository testRepository;

	@Autowired
	private ProjectRepository projectRepository;

	/* creating test based on project id */
	public Test createTest(Long projectId, Test test) {
		return projectRepository.findById(projectId).map(project -> {
			test.setProject(project); // injecting project to test
			return testRepository.save(test);
		}).orElseThrow(() -> new ResourceNotFoundException("ProjectId " + projectId + " not found"));
	}



	//get All tests by project id
	public Page<Test> getAllTestsByProjectId(Project project, Pageable pageable)
	{ 
		return testRepository.findByProject(project, pageable); 

	}



	public Test getTestById(Long testId) {

		Optional<Test> test=testRepository.findById(testId);
		return test.orElseThrow(()->new RuntimeException("couldn't find user with testId"+testId));
	}


	public void deleteTestById(Long testId) {
		testRepository.deleteById(testId);
	}








}
