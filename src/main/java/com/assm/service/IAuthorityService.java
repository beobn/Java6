package com.assm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assm.modal.Account;
import com.assm.modal.Authority;
import com.assm.modal.Role;

public interface IAuthorityService {
	public List<Authority> getall();
	
	public Authority create(Authority auth);
	
	public void delete(Integer id);
	
	public List<Authority> findByUsernameAndRole(Account ac,Role role);
}
