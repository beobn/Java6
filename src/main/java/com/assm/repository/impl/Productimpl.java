package com.assm.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assm.modal.Account;
import com.assm.modal.Category;
import com.assm.modal.Product;
import com.assm.repository.CategoryRepository;
import com.assm.repository.ProductRepository;
import com.assm.service.IProductSevice;

@Service
public class Productimpl implements IProductSevice{

	@Autowired
	ProductRepository dao;
	
	@Autowired
	CategoryRepository dao1;
	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Product> getall() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Product add(Product prd) {
		// TODO Auto-generated method stub
		return dao.save(prd);
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Category> listcate() {
		// TODO Auto-generated method stub
		return dao1.findAll();
	}
	@Override
	public List<Product> findByCate(String idcate) {
		return dao.findByCategory_id(idcate);
	}

}
