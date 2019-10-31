package com.loadwave.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loadwave.project.model.TestRun;

@Repository
public interface TestRunRepository extends JpaRepository<TestRun, Long> {

}
