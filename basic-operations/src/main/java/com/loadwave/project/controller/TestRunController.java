package com.loadwave.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loadwave.project.model.Project;
import com.loadwave.project.model.Test;
import com.loadwave.project.model.TestRun;
import com.loadwave.project.repository.TestRepository;
import com.loadwave.project.repository.TestRunRepository;
import com.loadwave.project.service.ProjectService;
import com.loadwave.project.service.TestRunService;
import com.loadwave.project.service.TestService;

@RestController
public class TestRunController {

	@Autowired
	private TestRunService testRunService ;

	@Autowired
	private TestRunRepository testRunRepository;

	@Autowired
	private TestRepository testRepository;
	
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TestService testService;
	
	/*
	 * @PostMapping("/projects/{projectId}/{test_Id}/createtestrun") public TestRun
	 * createTestRun(@PathVariable Long projectId,@PathVariable Long
	 * test_Id, @RequestBody TestRun testrun) {
	 * projectRepository.findById(projectId).map(project -> { Optional<Test> test
	 * =testRepository.findById(test_Id); test.setProject(project); // injecting
	 * project to test
	 * 
	 * testRepository.findById(testId).map(test -> { test.setTest(test); return
	 * testRunRepository.save(testrun); }).orElseThrow(() -> new
	 * ResourceNotFoundException("ProjectId " + projectId + " not found")); } }
	 */
	
	
	  //create testrun by project(projectId) and test(testId)
	@PostMapping("/projects/{projectId}/{test_Id}/createtestrun") 
	public TestRun createTestRun(@PathVariable Long projectId,@PathVariable Long test_Id, @RequestBody TestRun testrun) {
		 Project project = projectService.getProjectById(projectId);
		 Test test       = testService.getTestById(test_Id);
		 test.setProject(project);
		 testrun.setTest(test);
		
		return testRunRepository.save(testrun);
	}
	

	/*
	 * //get testrun by id
	 * 
	 * @GetMapping("/testrun/{testrun_Id}") public TestRun
	 * getTestRunById(@PathVariable Long testrun_Id) { return
	 * testRunService.getTestRunById(testrun_Id); }
	 */
	@GetMapping("/testrun/{testrun_Id}")
	public TestRun getTestById(@PathVariable Long testrun_Id) {

		return  testRunService.getTestRunById(testrun_Id);
	}
	
	}

	
	

