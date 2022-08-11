package com.assm.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.assm.modal.Product;
import com.assm.service.IProductSevice;

@Controller @RequestMapping("/product")
public class ProductController {
	
	@Autowired
	IProductSevice sv;
	
	@RequestMapping("/list")
	public String list(Model model,@RequestParam(name="cateid",defaultValue = "") String cateid) {
		List<Product> listPrd= new ArrayList<Product>();
		if(cateid.equals("")) {
			listPrd= sv.getall();
		}else {
			listPrd=sv.findByCate(cateid);
		}
		model.addAttribute("listPrd",listPrd);
		return "/view/products/list";
	}
	@RequestMapping("/detail/{id}")
	public String detail(Model model,@PathVariable(name="id")Integer id) {
		Product prdd = sv.findById(id);
		model.addAttribute("prdd", prdd);
		return "/view/products/detail";
	}


}
