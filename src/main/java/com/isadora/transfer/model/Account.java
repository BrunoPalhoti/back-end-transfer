package com.isadora.transfer.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String accountOring;
	String accountDestin;
	double velue;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	LocalDate dateScheduled;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	LocalDate dateTransfer;
	String period;
	double rate;

}
