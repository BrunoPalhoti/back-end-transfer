package com.isadora.transfer.resourse;

import java.util.List;
import java.util.stream.Collectors;
import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isadora.transfer.model.Account;
import com.isadora.transfer.model.dto.AccountDto;
import com.isadora.transfer.services.AccountService;
import com.isadora.transfer.services.impl.AccountServiceImpl;

@RestController
@RequestMapping(value = "/transfer")
public class AccountResoucer {
	
	public static final String ID = "/{id}";
	
	@Autowired
	private AccountService accountService;

////	@GetMapping
//	public ResponseEntity<List<AccountDto>> findAll(){
//		return ResponseEntity.ok()
//				.body(accountService.findAll()
//						.stream().map(x -> mapper.map(x, AccountDto.class)).collect(Collectors.toList()));
//	}
//	
	@PostMapping
	public ResponseEntity<AccountDto> create(@RequestBody Account accountDto){
		accountDto.setDateTransfer(LocalDate.now());
		accountService.create(accountDto);
		return new ResponseEntity<AccountDto>(HttpStatus.CREATED);
	}
}
