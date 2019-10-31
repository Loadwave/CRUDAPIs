package com.loadwave.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loadwave.project.exception.ResourceNotFoundException;
import com.loadwave.project.model.Project;
import com.loadwave.project.model.Test;
import com.loadwave.project.repository.TestRepository;
import com.loadwave.project.service.ProjectService;
import com.loadwave.project.service.TestService;

@RestController
public class TestController {

	@Autowired
	private TestService testService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TestRepository testRepository;


     //create test by projectId
	@PostMapping("/projects/{projectId}/createtest")
	public Test createTest(@PathVariable Long projectId,@RequestBody Test test) {
		return testService.createTest(projectId, test) ;

	}

	/*
	 * @GetMapping("/project/{projectId}/tests/") public List<Test>
	 * getAllTestsByProjectId(@PathVariable Long projectId){ return
	 * testService.getAllTestsByProjectId(projectId) ; }
	 */


	//get all tests based on projectId
	@GetMapping("/projects/{projectId}/tests") public Page<Test>
	getAllTestsByProjectId(@PathVariable("projectId") Long projectId,Pageable
			pageable)
	{ 
		Project project = projectService.getProjectById(projectId);
		return testService.getAllTestsByProjectId(project, pageable); 
	}

	
	//delete test by project id
	@DeleteMapping("/projects/{projectId}/tests/{testId}")
	public void deleteTest(@PathVariable Long projectId,@PathVariable Long testId,Pageable pageable) {
		Project project = projectService.getProjectById(projectId);
		Page <Test> tests= testService.getAllTestsByProjectId(project, pageable);
		for (Test test : tests) {
			if(test.getTest_Id()==testId) {
				//testRepository.deleteById(testId);
				testService.deleteTestById(testId);
			}
		}
	}


	@PutMapping("/projects/{projectId}/tests/{testId}")
	public Test updateTest(@PathVariable Long projectId,@PathVariable Long testId,@RequestBody Test testRequest,Pageable pageable) {
		Project project = projectService.getProjectById(projectId);
		Page <Test> tests= testService.getAllTestsByProjectId(project, pageable);
		for (Test test : tests) {
			if(test.getTest_Id()==testId) {
				testRepository.findById(testId).map(testit -> {
					test.setDesc(testRequest.getDesc());
					test.setDuration(testRequest.getDuration());
					test.setPath(testRequest.getPath());
					test.setTest_Name(testRequest.getTest_Name());
					test.setTest_Type_Id(testRequest.getTest_Type_Id());
					test.setUsers(testRequest.getUsers());
					return testRepository.save(test);
				}).orElseThrow(() -> new ResourceNotFoundException("testId " + testId + "not found"));
			}
		}
		return null;  
	}

	
	@GetMapping("/tests/{testId}")
	public Test getTestById(@PathVariable Long testId) {

		return  testService.getTestById(testId);
	}
	
	
	
	
}





