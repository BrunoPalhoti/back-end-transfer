package com.isadora.transfer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;

import com.isadora.transfer.enums.TypeAccountEnum;
import com.isadora.transfer.factory.AccountFactory;
import com.isadora.transfer.model.Account;
import com.isadora.transfer.model.dto.AccountDto;
import com.isadora.transfer.repository.AccountRepository;
import com.isadora.transfer.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountFactory accountFactory;

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public void create(Account obj) {
		//Double difference = (double) ChronoUnit.DAYS.between(obj.getDateTransfer(),obj.getDateScheduled());
		Double rate = null;
		
		if(obj.getPeriod().equals(TypeAccountEnum.A)){
			rate = accountFactory.rateA(obj);
			obj.setRate(rate);
		
		} else if(obj.getPeriod().equals(TypeAccountEnum.B)) {
			rate = accountFactory.rateB(obj);
			obj.setRate(rate);
			
		} else if(obj.getPeriod().equals(TypeAccountEnum.C)) {
			rate = accountFactory.rateC(obj);
			obj.setRate(rate);
			
		} else if(obj.getPeriod().equals(TypeAccountEnum.D)) {
			rate = accountFactory.rateD(obj);
			obj.setRate(rate);
			
		}
		
		accountRepository.save(obj);
	}		
}


