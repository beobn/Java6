package com.assm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.assm.modal.Account;
import com.assm.modal.Order;

public interface IOderService {
	public void add(Account ac,HttpSession session, String address);
	public List<Order> getall(Account ac);
}
