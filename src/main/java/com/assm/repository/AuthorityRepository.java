package com.assm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assm.modal.Account;
import com.assm.modal.Authority;
import com.assm.modal.Role;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer>{
	List<Authority> findByAccountAndRole(Account account,Role role);
}
