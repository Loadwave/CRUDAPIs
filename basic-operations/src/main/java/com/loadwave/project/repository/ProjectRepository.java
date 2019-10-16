package com.loadwave.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loadwave.project.model.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	

}
