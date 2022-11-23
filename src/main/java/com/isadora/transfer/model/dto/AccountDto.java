package com.isadora.transfer.model.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

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
	
	@NotNull
	private String accountOring;
	
	@NotNull
	private String accountDestin;
	
	@NotNull
	private double velue;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	LocalDate dateScheduled;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateTransfer;
	
	@NotNull
	private String period;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private double rate;
	
}
