package com.ness.loanapp.exceptions;

public class LoanNotFoundException extends RuntimeException {
	public LoanNotFoundException(String message){
		super(message);
	}

}
