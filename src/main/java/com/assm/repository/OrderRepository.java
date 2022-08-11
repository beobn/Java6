package com.assm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assm.modal.Account;
import com.assm.modal.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	 List<Order> findByAccount(Account account);
}
