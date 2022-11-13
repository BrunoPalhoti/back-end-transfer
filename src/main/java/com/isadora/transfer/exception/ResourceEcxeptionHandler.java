package com.isadora.transfer.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceEcxeptionHandler {
	
	@ExceptionHandler(RateCalculationException.class)
	public ResponseEntity<StandardError> ErroRateCalculation(RateCalculationException ex, HttpServletRequest request){
		StandardError error = new StandardError(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(), 
				ex.getMessage(), 
				request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
