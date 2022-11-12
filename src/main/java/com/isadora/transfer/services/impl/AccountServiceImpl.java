package com.isadora.transfer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import com.isadora.transfer.factory.AccountFactory;
import com.isadora.transfer.model.Account;
import com.isadora.transfer.repository.AccountRepository;
import com.isadora.transfer.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	AccountFactory accountFactory;

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public void create(Account obj) {
		Double differenceDays = (double) ChronoUnit.DAYS.between(obj.getDateTransfer(),obj.getDateScheduled());
		Double rate = null;
		
		if((obj.getPeriod().equals("A")) && (obj.getDateScheduled().equals(obj.getDateTransfer())) ){
			rate = accountFactory.rateA(obj);
			obj.setRate(rate);
			accountRepository.save(obj);
		
		} else if((obj.getPeriod().equals("B") && (differenceDays > 0 && differenceDays < 10))) {
			rate = accountFactory.rateB(obj);
			obj.setRate(rate);
			accountRepository.save(obj);
			
		} else if((obj.getPeriod().equals("C")) && (differenceDays > 10)) {
			rate = accountFactory.rateC(obj);
			obj.setRate(rate);
			accountRepository.save(obj);
			
		} else if(obj.getPeriod().equals("D")) {
			rate = accountFactory.rateD(obj);
			obj.setRate(rate);
			accountRepository.save(obj);
			
		}
	}		
}


