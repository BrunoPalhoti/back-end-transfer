package com.isadora.transfer.services;

import java.util.List;
import com.isadora.transfer.model.Account;

public interface AccountService {
	List<Account> findAll();
	void create(Account obj);
}
