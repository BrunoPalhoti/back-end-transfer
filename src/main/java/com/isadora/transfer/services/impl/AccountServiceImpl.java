package com.isadora.transfer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;

import com.isadora.transfer.enums.TypeAccountEnum;
import com.isadora.transfer.model.Account;
import com.isadora.transfer.model.dto.AccountDto;
import com.isadora.transfer.repository.AccountRepository;
import com.isadora.transfer.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public AccountDto create(AccountDto obj) {
		return valueRate(obj);
	}		

	private AccountDto valueRate(AccountDto obj) {
		Double difference = (double) ChronoUnit.DAYS.between(obj.getDateScheduled(), obj.getDateTransfer());
		
		if(obj.getPeriod().equals(TypeAccountEnum.A) || obj.getPeriod().equals(TypeAccountEnum.D)) {
			if(obj.getVelue() <= 1000.00 ||difference.equals(0)) {
			    obj.setRate(3 + (obj.getVelue() * 0.03));
			    
			}
		} else if(obj.getPeriod().equals(TypeAccountEnum.B) || obj.getPeriod().equals(TypeAccountEnum.D)) {
			if((obj.getVelue() > 1000.00 && obj.getVelue() <= 2000.00) 
					|| (difference > 0 && difference <= 10)) {
				obj.setRate(12.00);
				
			}
		} else if(obj.getPeriod().equals(TypeAccountEnum.C) || obj.getPeriod().equals(TypeAccountEnum.D)) {
			 if(obj.getVelue() > 2000.00 || (difference > 10 && difference <= 20)) {
				obj.setRate(obj.getVelue() * 0.082);
				
			} else if(obj.getVelue() > 2000.00 || (difference > 20 && difference <= 30)) {
				obj.setRate(obj.getVelue() * 0.069);
				
			} else if(obj.getVelue() > 2000.00 || (difference > 30 && difference <= 40)) {
				obj.setRate(obj.getVelue() * 0.047);
				
			} else if(obj.getVelue() > 2000.00 || difference > 40) {
				obj.setRate(obj.getVelue() *  0.017);
			}
		}
		
		accountRepository.save(obj);
		return obj;
	}
}


