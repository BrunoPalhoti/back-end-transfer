package com.isadora.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isadora.transfer.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
