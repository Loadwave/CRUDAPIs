package com.loadwave.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loadwave.project.model.Test;


@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

	
}
