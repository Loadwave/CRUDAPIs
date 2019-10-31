package com.loadwave.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loadwave.project.model.Project;
import com.loadwave.project.model.Test;


@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

	/* public List<Test> findByProjectId(Long projectId); */

	Page<Test> findByProject(Project project, Pageable pageable);
}
