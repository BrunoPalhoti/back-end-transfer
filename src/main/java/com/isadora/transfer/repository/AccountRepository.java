package com.isadora.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isadora.transfer.model.Account;
import com.isadora.transfer.model.dto.AccountDto;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	double save(AccountDto obj);

}
