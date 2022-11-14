package com.isadora.transfer.factory;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.isadora.transfer.model.dto.AccountDto;

@Component
public class ValidationFactory {
	
	public Boolean validation(AccountDto accountDto) {
		
		if((Objects.nonNull(accountDto.getPeriod()) && 
				(Objects.nonNull(accountDto.getAccountDestin()) && 
						(Objects.nonNull(accountDto.getAccountOring()) && 
								(Objects.nonNull(accountDto.getDateScheduled()) && 
										(Objects.nonNull(accountDto.getDateTransfer()) && 
												(Objects.nonNull(accountDto.getPeriod()) 
														&& (Objects.nonNull(accountDto.getVelue()))))))))) {
			return true;
		}else {
			return false;
		}
	}
}
