package com.assm.repository.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.stereotype.Service;

import com.assm.modal.Cart;
import com.assm.modal.Product;
import com.assm.service.ICartService;

@Service
public class Cartimpl implements ICartService{

	@Override
	public void add(HttpSession session,Product prd) {
		// TODO Auto-generated method stub
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		Cart cart = new Cart();
		if(listcart == null) {
			listcart = new ArrayList<Cart>();
			cart.setPrd(prd);
			cart.setQuantity(1);
			listcart.add(cart);
			session.setAttribute("listcart", listcart);
			return;
		}else {
			for(int i=0;i<listcart.size();i++) {
				if(listcart.get(i).getPrd().getId()==prd.getId()) {
					listcart.get(i).setQuantity(listcart.get(i).getQuantity()+1);
					session.setAttribute("listcart", listcart);
					return;
				}
			}
			cart.setPrd(prd);
			cart.setQuantity(1);
			listcart.add(cart);
			session.setAttribute("listcart", listcart);
			return;
		}
		
	}
	@Override
	public void detele(HttpSession session,Product prd) {
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		for(int i=0;i<listcart.size();i++) {
			if(listcart.get(i).getPrd().getId()==prd.getId()) {
				listcart.remove(i);
				session.setAttribute("listcart", listcart);
				return;
			}
		}
	}
	@Override
	public List<Cart> getall(HttpSession session) {
		// TODO Auto-generated method stub
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		return listcart;
	} 
	@Override
	public String messcart() {
		// TODO Auto-generated method stub
		HttpSession session = null ;
		List<Cart> getall = getall(session);
		return null;
	}
	@Override
	public void Update(HttpSession session, Product prd, Integer quantity) {
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		for(int i=0;i<listcart.size();i++) {
			if(listcart.get(i).getPrd().getId()==prd.getId()) {
				listcart.get(i).setQuantity(quantity);
				session.setAttribute("listcart", listcart);
				return;
			}
		}
		
	}
}
