package com.assm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assm.modal.Category;


public interface ICategoryService {
	public Category findById(String id);
	public List<Category> getall();
	public Category add(Category cate);
	public void delete(String id);
}
