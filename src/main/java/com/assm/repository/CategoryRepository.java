package com.assm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assm.modal.Category;
import com.assm.modal.OrderDetail;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
