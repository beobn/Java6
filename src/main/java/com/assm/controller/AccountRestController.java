package com.assm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.assm.modal.Account;
import com.assm.repository.AccountsRepository;
import com.assm.service.IAccountService;

@RestController @RequestMapping("/rest/account")
public class AccountRestController {
	
	
	@Autowired
	IAccountService sv;
	
	@RequestMapping("/getall")
	public List<Account> getall(){
		return sv.getall();
	}
	
	@RequestMapping("/add")
	public Account add(@RequestBody Account ac){
		return sv.add(ac);
	}
	@RequestMapping("/edit/{id}")
	public Account formedit(@PathVariable String id){
		return sv.formedit(id);
	}
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable String id){
		sv.delete(id);
	}
}
