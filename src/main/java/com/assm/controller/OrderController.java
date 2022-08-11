package com.assm.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.support.SecurityWebApplicationContextUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assm.modal.Account;
import com.assm.modal.Order;
import com.assm.modal.OrderDetail;
import com.assm.service.IAccountService;
import com.assm.service.IOderService;
import com.assm.service.IOrderdetailService;


@Controller @RequestMapping("/order")
public class OrderController {

	@Autowired
	IOderService sv;
	
	@Autowired
	IAccountService sv1;
	
	@Autowired
	IOrderdetailService sv2;
		
	@RequestMapping("/checkout")
	public String checkout(@RequestParam(name="id")Long id) {
		
		return"/view/order/checkout";
	}
	@RequestMapping("/list")
	public String list(Model model,Authentication authentication) {
		List<Order>listord = sv.getall(sv1.findById(authentication.getName()));
		model.addAttribute("listord",listord);
		return"/view/order/list";
	}
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable String id,Model model) {
		List<OrderDetail> listodd = sv2.getall(Long.parseLong(id));
		Double summoney= 0.0;
		for(int i=0;i<listodd.size();i++) {
			summoney=summoney+listodd.get(i).getPrice();
		}
		model.addAttribute("summoney",summoney);
		model.addAttribute("listodd",listodd);
		model.addAttribute("odd",listodd.get(0));
		return"/view/order/detail";
	}
	@RequestMapping("/add/{ussername}")
	public String add(HttpSession session, @PathVariable String ussername, @RequestParam(name="address")String address) {
		sv.add(sv1.findById(ussername), session, address);
		return"redirect:/order/list";
	}
}
