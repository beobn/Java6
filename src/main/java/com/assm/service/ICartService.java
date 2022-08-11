package com.assm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.assm.modal.Cart;
import com.assm.modal.Product;

public interface ICartService {
	public List<Cart> getall(HttpSession session);
	public void detele(HttpSession session,Product prd);
	public void add(HttpSession session,Product prd);
	public String messcart();
	public void Update(HttpSession session,Product prd,Integer quantity);
}
