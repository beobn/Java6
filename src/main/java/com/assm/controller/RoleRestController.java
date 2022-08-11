package com.assm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assm.modal.Role;
import com.assm.service.IRoleService;
@CrossOrigin("*")
@RestController @RequestMapping("/rest/role")
public class RoleRestController {
	
	@Autowired
	IRoleService sv;
	@RequestMapping("/getall")
	public List<Role> getall(){
		return sv.getall();
	}
}
