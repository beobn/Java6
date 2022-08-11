package com.assm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assm.modal.Role;

@Service
public interface IRoleService {
	public List<Role> getall();
}
