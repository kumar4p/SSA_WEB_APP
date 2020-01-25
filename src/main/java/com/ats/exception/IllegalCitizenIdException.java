package com.ats.exception;

public class IllegalCitizenIdException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public IllegalCitizenIdException() {

	}

	public IllegalCitizenIdException(String message) {
		super(message);
	}

}
