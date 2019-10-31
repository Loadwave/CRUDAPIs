package com.loadwave.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loadwave.project.model.Test;
import com.loadwave.project.model.TestRun;
import com.loadwave.project.repository.TestRunRepository;

@Service
public class TestRunService {

	@Autowired
	private TestRunRepository testRunRepository;



	
	  public TestRun getTestRunById(Long testrun_Id) 
	  { 
		  Optional<TestRun> testrun=testRunRepository.findById(testrun_Id); 
		  return
	             testrun.orElseThrow(()->new
	             RuntimeException("couldn't find user with id"+testrun_Id));
	  
	  }
	 
	
	
	/*
	 * public TestRun getTestRunById(Long testrun_Id) { return
	 * testRunRepository.getOne(testrun_Id); }
	 */
	
	
	

}
