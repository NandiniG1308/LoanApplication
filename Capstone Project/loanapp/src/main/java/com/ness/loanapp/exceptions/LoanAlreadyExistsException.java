package com.ness.loanapp.exceptions;

public class LoanAlreadyExistsException extends RuntimeException{
	public LoanAlreadyExistsException(String message){
		super(message);
	}

}
