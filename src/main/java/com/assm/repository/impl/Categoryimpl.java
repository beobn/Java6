package com.assm.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assm.modal.Category;
import com.assm.repository.CategoryRepository;
import com.assm.service.ICategoryService;

@Service
public class Categoryimpl implements ICategoryService {

	@Autowired
	CategoryRepository dao;
	
	
	@Override
	public Category findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Category> getall() {
		return dao.findAll();
	}

	@Override
	public Category add(Category cate) {
		return dao.save(cate);
	}


	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	

}
