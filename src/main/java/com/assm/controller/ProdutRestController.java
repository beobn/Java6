package com.assm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assm.modal.Account;
import com.assm.modal.Category;
import com.assm.modal.Product;
import com.assm.service.IProductSevice;

@RestController @RequestMapping("/rest/product")
public class ProdutRestController {

	@Autowired
	IProductSevice sv;
	
	@RequestMapping("/getall")
	public List<Product> getall(){
		return sv.getall();
	}
	
	@RequestMapping("/add")
	public Product add(@RequestBody Product prd){
		return sv.add(prd);
	}

	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable Integer id){
		sv.delete(id);
	}
	@RequestMapping("/getcate")
	public List<Category> getcate(){
		return sv.listcate();
	}
	
	@RequestMapping("/edit/{id}")
	public Product find(@PathVariable Integer id) {
		return sv.findById(id);
	}
}
