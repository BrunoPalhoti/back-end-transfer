package com.isadora.transfer.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	LocalDate dateScheduled;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateTransfer;
	private String period;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private double rate;
	
}
