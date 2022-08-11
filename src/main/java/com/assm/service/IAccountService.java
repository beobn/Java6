package com.assm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assm.modal.Account;

@Service
public interface IAccountService {
	public Account findById(String username);
	public List<Account> getall();
	public Account add(Account ac);
	public Account formedit(String id);
	public void delete(String id);
	
	
}
