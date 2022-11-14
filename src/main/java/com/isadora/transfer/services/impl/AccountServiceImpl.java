package com.isadora.transfer.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import com.isadora.transfer.factory.AccountFactory;
import com.isadora.transfer.model.Account;
import com.isadora.transfer.model.dto.AccountDto;
import com.isadora.transfer.repository.AccountRepository;
import com.isadora.transfer.services.AccountService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	AccountFactory accountFactory;
	
	@Autowired
    private ModelMapper mapper;

	@Override
	public List<Account> findAll() {
		log.info("Iniciando a busaca dos agendamentos no banco");
		return accountRepository.findAll();
	}

	@Override
	public Account create(AccountDto obj) {
		log.info("Iniciando o agendamento no banco");
		Double differenceDays = (double) ChronoUnit.DAYS.between(obj.getDateTransfer(),obj.getDateScheduled());
		Double rate = null;
		
		if((obj.getPeriod().equals("A")) && (obj.getDateScheduled().equals(obj.getDateTransfer())) ){
			rate = accountFactory.rateA(obj);
			obj.setRate(rate);
		
		} else if((obj.getPeriod().equals("B") && (differenceDays > 0 && differenceDays < 10))) {
			rate = accountFactory.rateB(obj);
			obj.setRate(rate);
			
		} else if((obj.getPeriod().equals("C")) && (differenceDays > 10)) {
			rate = accountFactory.rateC(obj);
			obj.setRate(rate);
			
		} else if(obj.getPeriod().equals("D")) {
			rate = accountFactory.rateD(obj);
			obj.setRate(rate);
			
		}
		log.info("Agendamento salvo no banco com sucesso");
		return accountRepository.save(mapper.map(obj, Account.class));
	}		
}


