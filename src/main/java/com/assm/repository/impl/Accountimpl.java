package com.assm.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assm.modal.Account;
import com.assm.repository.AccountsRepository;
import com.assm.service.IAccountService;

@Service
public class Accountimpl implements IAccountService{

@Autowired
AccountsRepository dao;

@Override
public Account findById(String username) {
	// TODO Auto-generated method stub
	return dao.findById(username).get();
}
 @Override
public List<Account> getall() {
	return dao.findAll();
}
 @Override
	public Account add(Account ac) {
		// TODO Auto-generated method stub
		return dao.save(ac);
	}
@Override
	public Account formedit(String id) {
		return dao.findById(id).get();
	}
@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
}
