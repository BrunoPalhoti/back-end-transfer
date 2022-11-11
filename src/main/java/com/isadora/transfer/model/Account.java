package com.isadora.transfer.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	String accountOring;
	String accountDestin;
	double velue;
	LocalDateTime dateScheduled = LocalDateTime.now();
	LocalDateTime dateTransfer;

}
