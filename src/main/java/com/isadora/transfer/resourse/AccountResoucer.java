package com.isadora.transfer.resourse;

import java.util.List;
import java.util.stream.Collectors;
import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isadora.transfer.model.dto.AccountDto;
import com.isadora.transfer.services.AccountService;

@RestController
@RequestMapping(value = "/transfer")
public class AccountResoucer {
	
	public static final String ID = "/{id}";
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> findAll(){
		return ResponseEntity.ok()
				.body(accountService.findAll()
						.stream().map(x -> mapper.map(x, AccountDto.class)).collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path(ID).buildAndExpand(accountService.create(accountDto).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
