package com.assm.service;

import java.util.List;

import com.assm.modal.OrderDetail;

public interface IOrderdetailService {
	List<OrderDetail> getall(Long id);
}
