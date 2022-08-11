package com.assm.repository.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assm.modal.Account;
import com.assm.modal.Cart;
import com.assm.modal.Order;
import com.assm.modal.OrderDetail;
import com.assm.repository.OrderDetailRepository;
import com.assm.repository.OrderRepository;
import com.assm.service.IOderService;

@Service
public class Orderimpl implements IOderService {
	
	@Autowired
	OrderRepository dao;
	
	@Autowired
	OrderDetailRepository dao1;
	
	@Override
	public void add(Account ac, HttpSession session, String address) {
		// TODO Auto-generated method stub
		Order od = new Order();
		od.setAccount(ac);
		od.setAddress(address);
		od.setCreateDate(new Date());
		dao.save(od);
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		for(int i=0;i<listcart.size();i++) {
			OrderDetail odd= new OrderDetail();
			odd.setOrder(od);
			odd.setPrice(listcart.get(i).getPrd().getPrice()*listcart.get(i).getQuantity());
			odd.setProduct(listcart.get(i).getPrd());
			odd.setQuantity(listcart.get(i).getQuantity());
			dao1.save(odd);
		}
		
		session.setAttribute("listcart",null);
		
	}
	@Override
	public List<Order> getall(Account ac) {
		// TODO Auto-generated method stub
		return dao.findByAccount(ac);
	}
}
