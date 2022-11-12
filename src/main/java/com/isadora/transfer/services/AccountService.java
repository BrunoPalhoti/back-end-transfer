package com.isadora.transfer.services;

import java.util.List;
import com.isadora.transfer.model.Account;
import com.isadora.transfer.model.dto.AccountDto;

public interface AccountService {
	List<Account> findAll();
	void create(Account obj);
}
