package com.assm.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assm.modal.Account;
import com.assm.modal.Authority;
import com.assm.modal.Role;
import com.assm.repository.AuthorityRepository;
import com.assm.service.IAuthorityService;

@Service
public class Authorityimpl implements IAuthorityService{
	
	@Autowired
	AuthorityRepository dao;
	
	@Override
	public Authority create(Authority auth) {
		// TODO Auto-generated method stub
		return dao.save(auth);
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	@Override
	public List<Authority> findByUsernameAndRole(Account ac, Role role) {
		// TODO Auto-generated method stub
		return dao.findByAccountAndRole(ac, role);
	} 
	@Override
	public List<Authority> getall() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
