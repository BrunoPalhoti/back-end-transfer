package com.isadora.transfer.resourse;

import java.util.List;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.isadora.transfer.model.Account;
import com.isadora.transfer.model.dto.AccountDto;
import com.isadora.transfer.services.AccountService;

@RestController
@RequestMapping(value = "/transfer")
public class AccountResoucer {
	
	@Autowired
	private AccountService accountService;

	@GetMapping
	public ResponseEntity<List<?>> findAll(){
		return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
						
	}
	
	@PostMapping
	public ResponseEntity<AccountDto> create(@RequestBody Account accountDto){
		accountDto.setDateTransfer(LocalDate.now());
		accountService.create(accountDto);
		return new ResponseEntity<AccountDto>(HttpStatus.CREATED);
	}
}
