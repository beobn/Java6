package com.assm.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assm.modal.Role;
import com.assm.repository.RoleRepository;
import com.assm.service.IRoleService;

@Service
public class Roleimpl implements IRoleService{
	
	@Autowired
	RoleRepository dao;
	
	@Override
	public List<Role> getall() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
