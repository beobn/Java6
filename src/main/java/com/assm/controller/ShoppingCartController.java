package com.assm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.assm.modal.Cart;
import com.assm.modal.Product;
import com.assm.service.ICartService;
import com.assm.service.IProductSevice;

@Controller @RequestMapping("/cart")
public class ShoppingCartController {
	
	@Autowired
	ICartService sv; 
	
	@Autowired
	IProductSevice sv1;
	
	@RequestMapping("/getall")
	public String getall(HttpSession session,Model model){
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		model.addAttribute("listcart",listcart);
		return "/view/cart/view";
	}
	@RequestMapping("/add")
	public String add(HttpSession session,Model model,@RequestParam(name="idprd",defaultValue = "") Integer idprd){
		Product prdadd= sv1.findById(idprd);
		sv.add(session, prdadd);
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		model.addAttribute("listcart",listcart);
		return "redirect:/cart/getall";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpSession session,Model model,@RequestParam(name="idprd",defaultValue = "") Integer idprd){
		if(idprd==null) {
			session.removeAttribute("listcart");
			return "redirect:/cart/getall";
		}
		Product prdadd= sv1.findById(idprd);
		sv.detele(session, prdadd);
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		model.addAttribute("listcart",listcart);
		return "redirect:/cart/getall";
	}
	@RequestMapping("/update/{idprd}")
	public String update(HttpSession session,Model model,@PathVariable(name="idprd") Integer idprd,@RequestParam(name="quantity")Integer quantity){
		Product prdadd= sv1.findById(idprd);
		System.out.println(quantity);
		sv.Update(session, prdadd, quantity);
		List<Cart> listcart = (List<Cart>) session.getAttribute("listcart");
		model.addAttribute("listcart",listcart);
		return "redirect:/cart/getall";
	}
}
