package com.loadwave.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loadwave.project.model.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
               
	//public Account findByAccount_Id(Long account_Id);
}
