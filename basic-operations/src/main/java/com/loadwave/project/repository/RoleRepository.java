package com.loadwave.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loadwave.project.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
