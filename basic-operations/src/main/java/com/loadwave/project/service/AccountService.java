package com.loadwave.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loadwave.project.model.Account;
import com.loadwave.project.model.Project;
import com.loadwave.project.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;


	public Account createAccount(Account account) {
		return	accountRepository.save(account);	
	}

	public  Account getAccountById(Long account_Id) {
		Optional<Account> account = accountRepository.findById(account_Id); 
		return account.orElseThrow(() -> new
	    RuntimeException("couldn't find user with id" +account_Id )); }

}
