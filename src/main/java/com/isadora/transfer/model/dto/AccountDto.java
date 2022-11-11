package com.isadora.transfer.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	
	private Integer id;
	private String accountOring;
	private String accountDestin;
	private double velue;
	private LocalDateTime dateScheduled;
	private LocalDateTime dateTransfer;

}
