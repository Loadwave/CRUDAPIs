package com.loadwave.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loadwave.project.model.Test;
import com.loadwave.project.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	/*
	 * @GetMapping("/projects/{projectId}/tests/") public List<Test>
	 * getAllTestsByProjectId(@PathVariable Long projectId){ return
	 * testService.getAllTestsByProjectId(projectId) ;
	 * 
	 * }
	 */
	
	@PostMapping("project/{projectId}/createtest")
	public Test createTest(@PathVariable Long projectId,@RequestBody Test test) {
		return testService.createTest(projectId, test) ;
		
	}

	
}
