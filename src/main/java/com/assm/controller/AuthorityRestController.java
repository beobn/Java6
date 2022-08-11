package com.assm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assm.modal.Authority;
import com.assm.service.IAuthorityService;
@CrossOrigin("*")
@RestController @RequestMapping("/rest/authority")
public class AuthorityRestController {
	
	@Autowired
	IAuthorityService sv;
	
	@RequestMapping("/getall")
	public List<Authority> getall(){
		return sv.getall();
	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		sv.delete(id);
	}
	
	@RequestMapping("/change")
	public Authority change(@RequestBody Authority auth) {
		return sv.create(auth);
	}
	
}
