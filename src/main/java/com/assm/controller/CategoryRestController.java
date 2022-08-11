package com.assm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assm.modal.Category;
import com.assm.repository.CategoryRepository;
import com.assm.service.ICategoryService;

@RestController @RequestMapping("/rest/cate")
public class CategoryRestController {
	
	@Autowired
	ICategoryService sv ;
	
	@RequestMapping("/getall")
	public List<Category> getall(){
		System.out.println("dazooooooo");
		return sv.getall();
	}
	
	@RequestMapping("/add")
	public Category add(@RequestBody Category cate){
		return sv.add(cate);
	}
	@RequestMapping("/edit/{id}")
	public Category formedit(@PathVariable String id){
		return sv.findById(id);
	}
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable String id){
		sv.delete(id);
	}

}
