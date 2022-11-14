package com.isadora.transfer.resourse;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.isadora.transfer.exception.RateCalculationException;
import com.isadora.transfer.factory.ValidationFactory;
import com.isadora.transfer.model.dto.AccountDto;
import com.isadora.transfer.services.AccountService;

@RestController
@RequestMapping(value = "/transfer")
public class AccountResoucer {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	ValidationFactory validationFactory;

	@GetMapping
	public ResponseEntity<List<?>> findAll(){
		
		return ResponseEntity.ok()
				.body(accountService.findAll()
						.stream().map(x -> mapper.map(x, AccountDto.class)).collect(Collectors.toList()));	
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody AccountDto accountDto){
		accountDto.setDateTransfer(LocalDate.now());
			
		if(this.validationFactory.validation(accountDto) == true) {
			accountService.create(accountDto);
		}else {
			throw new RateCalculationException("Erro ao calcular a taxa");
		}
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
