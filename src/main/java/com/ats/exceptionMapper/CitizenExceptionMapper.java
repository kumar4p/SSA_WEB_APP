package com.ats.exceptionMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ats.error.CitizenError;
import com.ats.exception.IllegalCitizenIdException;

@ControllerAdvice
public class CitizenExceptionMapper {
	
	@ExceptionHandler(IllegalCitizenIdException.class)
	public ResponseEntity< CitizenError> handleCitizenIdException(){
		CitizenError error = new CitizenError();
		error.setErrorMsg("NO Citizen Record For Given SSA Id");
		error.setErrorCode("TCS007");
		return new ResponseEntity<CitizenError>(error,HttpStatus.BAD_REQUEST);
	}
	
}
