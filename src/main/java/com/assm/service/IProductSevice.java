package com.assm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assm.modal.Account;
import com.assm.modal.Category;
import com.assm.modal.Product;

@Service
public interface IProductSevice {
	public Product findById(Integer id);
	public List<Product> getall();
	public Product add(Product prd);
	public void delete(Integer id);
	public List<Category> listcate();
	public List<Product> findByCate(String idcate);
}
