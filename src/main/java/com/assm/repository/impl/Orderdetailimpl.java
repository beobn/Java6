package com.assm.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assm.modal.OrderDetail;
import com.assm.repository.OrderDetailRepository;
import com.assm.repository.OrderRepository;
import com.assm.service.IOrderdetailService;

@Service
public class Orderdetailimpl implements IOrderdetailService{
	
	@Autowired
	OrderDetailRepository dao;
	
	@Autowired
	OrderRepository dao1;
	
	@Override
	public List<OrderDetail> getall(Long id) {
		// TODO Auto-generated method stub
		
		return dao.findByOrder(dao1.findById(id).get());
	}
}
