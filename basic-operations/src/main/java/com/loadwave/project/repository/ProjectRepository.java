package com.loadwave.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loadwave.project.model.Account;
import com.loadwave.project.model.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	Page<Project> findByAccount(Account account, Pageable pageable);
	
	
	//Project findByAccount(Account account,Long project_Id);
	
	}
