package com.ness.loanapp.services;

import java.util.List;

import com.ness.loanapp.models.Loan;

public interface LoanService {

	Loan applyLoan(Loan loan);

	Loan getLoansByLoanId(long loanId);
	
	Loan deposit(long loanId,double amount);
	
//	Double getBalanceByLoanId(Long LoanId);

//	Double getBalanceByLoanId(long loanId);

}
