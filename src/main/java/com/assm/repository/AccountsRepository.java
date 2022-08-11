package com.assm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assm.modal.Account;

@Repository
public interface AccountsRepository extends JpaRepository<Account, String> {

}
