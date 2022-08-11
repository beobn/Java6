package com.assm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assm.modal.Cart;

@Controller @RequestMapping("/security")
public class SecurityController {

	@RequestMapping("/login/form")
	public String form(Model model) {
		model.addAttribute("message","Vui lòng đăng nhập");
		return"view/security/login";
	}
	@RequestMapping("/login/success")
	public String loginSuccess(Model model,HttpSession session) {
		List<Cart> listcart = new ArrayList<Cart>();
		session.setAttribute("listcart", listcart);
		model.addAttribute("message","Đăng nhập thành công");
		return"view/security/login";
	}
	@RequestMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("message","Thông tin đăng nhập không hợp lệ");
		return"view/security/login";
	}
	
	@RequestMapping("/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message","Tài khoản chưa đủ quyền truy cập");
		return"view/security/unauthoried";
	}
	@RequestMapping("/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message","Đăng xuất thành công");
		return"view/security/login";
	}
}
