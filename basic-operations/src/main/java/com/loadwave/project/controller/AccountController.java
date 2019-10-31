package com.loadwave.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loadwave.project.model.Account;
import com.loadwave.project.service.AccountService;


@RestController
//@RequestMapping("/account")
public class AccountController {
	
	
	@Autowired
	private AccountService accountService;
	
	
	@PostMapping("account/create")
	public Account createAccount(@RequestBody Account account) {
		return	accountService.createAccount(account);	
	}

}
