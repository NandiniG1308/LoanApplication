package com.ness.loanapp.services;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountException;
import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ness.loanapp.models.Loan;
import com.ness.loanapp.repo.LoanRepository;
import com.ness.loanapp.exceptions.LoanAlreadyExistsException;
import com.ness.loanapp.exceptions.LoanNotFoundException;

@Service
public class LoanServiceImpl implements LoanService{
	
	
	@Autowired
	private LoanRepository loanrep;
	

	@Override
	public Loan applyLoan(Loan loan) {
//		long loanid=loan.getLoanId();
		long loanid=generateLoanId();
		
		
		
		if(loanrep.existsByLoanId(loanid)) {
			throw new LoanAlreadyExistsException("Loan Already Exists"+loanid);
		}
		
		String loanType = loan.getLoanType();
		loan.setLoanId(loanid);
		
		double Rate = getInterestRate(loan);
		int duration;
		double loanAmount=0;
		duration=loan.getDuration();
		loanAmount+=loan.getLoanAmt();
		
		
		// Calculate the EMI using the loan amount, interest rate, and duration
        double monthlyInterestRate = Rate / (12 * 100); // Convert annual interest rate to monthly interest rate
        int numberOfPayments = duration * 12; // Convert duration in years to number of monthly payments

        double monemi = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        
        int roundedEmi = (int) Math.round(monemi);
        loan.setEmi(roundedEmi);
        System.out.println("The Loan Monthly EMI to be paid "+roundedEmi);
        System.out.println("Your Loan ID is : "+loanid);
		
		
//		((LoanService) loan).addLoan(loan);
		return loanrep.save(loan);
		
//		Loan loan = loanrep.findAllById(loanid)
//				.Throw(() -> new LoanAlreadyExistsException("Loan Already Exists	: " + loanId));
//		loan.addLoan(loan);
//		return loanrep.save(loan);
//        
	}

	@Override
	public Loan getLoansByLoanId(long loanId) throws LoanNotFoundException{
		Optional<Loan> optionalAcc = loanrep.findById(loanId);
		if(optionalAcc.isEmpty()) {
			throw new LoanNotFoundException("Loan not found"+loanId);
		}
		return optionalAcc.get();
	}
	
//	public double getInterestRate(Loan loan) {
//		String loantype=loan.getLoanType();
//		switch (loantype) {
//		case "homeloan":
//			return 8.0;
//		case "educationloan":
//			return 11.0;
//		case "personalloan":
//			return 8.5;
//		default:
//			throw new IllegalArgumentException("Invalid loan type: " + loantype);
//  }
//	}
	
	
//	public double getInterestRate(Loan loan) {
//	    int creditScore = generateCreditScore();
//	    loan.setCreditscore(creditScore);
//	    String loanType = loan.getLoanType();
//
//	    if (creditScore >= 750) {
//	        // Excellent credit score
//	        switch (loanType) {
//	            case "homeloan":
//	                return 7.5;
//	            case "educationloan":
//	                return 10.0;
//	            case "personalloan":
//	                return 7.0;
//	            default:
//	                throw new IllegalArgumentException("Invalid loan type: " + loanType);
//	        }
//	    } else if (creditScore >= 700) {
//	        // Good credit score
//	        switch (loanType) {
//	            case "homeloan":
//	                return 8.0;
//	            case "educationloan":
//	                return 11.0;
//	            case "personalloan":
//	                return 8.5;
//	            default:
//	                throw new IllegalArgumentException("Invalid loan type: " + loanType);
//	        }
//	    } else if (creditScore >= 500) {
//	        // Average credit score
//	        switch (loanType) {
//	            case "homeloan":
//	                return 9.0;
//	            case "educationloan":
//	                return 12.0;
//	            case "personalloan":
//	                return 9.5;
//	            default:
//	                throw new IllegalArgumentException("Invalid loan type: " + loanType);
//	        }
//	    } else if (creditScore >= 400) {
//	        // Poor credit score
//	        switch (loanType) {
//	            case "homeloan":
//	                return 10.0;
//	            case "educationloan":
//	                return 13.0;
//	            case "personalloan":
//	                return 10.5;
//	            default:
//	                throw new IllegalArgumentException("Invalid loan type: " + loanType);
//	        }
//	    } else {
//	        // Very poor credit score
//	        throw new IllegalArgumentException("Loan not available for credit score: " + creditScore);
//	    }
//	}
	
	
	
	public double getInterestRate(Loan loan) {
	    int creditScore = generateCreditScore();
	    loan.setCreditscore(creditScore);
	    String loanType = loan.getLoanType();

	    if (loanType == null) {
	        throw new IllegalArgumentException("Loan type cannot be null");
	    }

	    if (creditScore >= 750) {
	        // Excellent credit score
	        switch (loanType) {
	            case "homeloan":
	                return 7.5;
	            case "educationloan":
	                return 10.0;
	            case "personalloan":
	                return 7.0;
	            default:
	                throw new IllegalArgumentException("Invalid loan type: " + loanType);
	        }
	    } else if (creditScore >= 700) {
	        // Good credit score
	        switch (loanType) {
	            case "homeloan":
	                return 8.0;
	            case "educationloan":
	                return 11.0;
	            case "personalloan":
	                return 8.5;
	            default:
	                throw new IllegalArgumentException("Invalid loan type: " + loanType);
	        }
	    } else if (creditScore >= 500) {
	        // Average credit score
	        switch (loanType) {
	            case "homeloan":
	                return 9.0;
	            case "educationloan":
	                return 12.0;
	            case "personalloan":
	                return 9.5;
	            default:
	                throw new IllegalArgumentException("Invalid loan type: " + loanType);
	        }
	    } else if (creditScore >= 400) {
	        // Poor credit score
	        switch (loanType) {
	            case "homeloan":
	                return 10.0;
	            case "educationloan":
	                return 13.0;
	            case "personalloan":
	                return 10.5;
	            default:
	                throw new IllegalArgumentException("Invalid loan type: " + loanType);
	        }
	    } else {
	        // Very poor credit score
	    	switch (loanType) {
            case "homeloan":
                return 11.0;
            case "educationloan":
                return 14.0;
            case "personalloan":
                return 11.5;
            default:
                throw new IllegalArgumentException("Invalid loan type: " + loanType);
	    }
	    }
	}

	
	
	
	
//	@Override
//	public void addLoan(Loan loan) {
//		
//		String loanType = loan.getLoanType();
//		double Rate = getInterestRate(loan);
//		int duration;
//		double loanAmount;
//		duration=loan.getDuration();
//		loanAmount=loan.getLoanAmt();
//		
//		// Calculate the EMI using the loan amount, interest rate, and duration
//        double monthlyInterestRate = Rate / (12 * 100); // Convert annual interest rate to monthly interest rate
//        int numberOfPayments = duration * 12; // Convert duration in years to number of monthly payments
//
//        double emi = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
//                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
//
//        System.out.println("The Loan Monthly EMI to be paid"+emi);
//		
//
//	}
	
	private Long generateLoanId() {
	       // Implement your logic to generate a 7-digit account number
	       // This could involve generating a random number or using a sequence generator
	       // Example:
	       long min = 100_000_0L; // Minimum 7-digit number
	       long max = 999_999_9L; // Maximum 7-digit number
	       long generatedNumber = min + (long) (Math.random() * (max - min));

       return Long.valueOf(generatedNumber);
	   }
	
	// THis is credit score generation
	
	private int generateCreditScore() {
	    int min = 300; // Minimum credit score
	    int max = 850; // Maximum credit score
	    int generatedCredit = min + (int) (Math.random() * (max - min));

	    return generatedCredit;
	}
	
	
	
	
//	
//	@Autowired
//    public TransactionService(TransactionRepository transactionRepository) {
//        this.transactionRepository = transactionRepository;
//    }
	
    public Loan deposit(long LoanId, double amount) throws LoanNotFoundException{
        Loan loan = loanrep.findById(LoanId)
                .orElseThrow(() -> new LoanNotFoundException("Account not found"));
        if(loan==null) {
        	throw new LoanNotFoundException("Loan not found");
        }
        double newBalance = loan.getLoanAmt() - amount;
        loan.setLoanAmt(newBalance);
        loan.setTransTime(LocalDateTime.now());
        return loanrep.save(loan);
    }
//    @Override
//    public Double getBalanceByLoanId(long LoanId)  {
//    	Double Balance;
//       Loan optionalloan = loanrep.findById(LoanId).get();
//         if (optionalloan!=null) {
//             Balance = optionalloan.getLoanAmt();
//            return Balance;
//        } else {
//            throw new LoanNotFoundException("Account not found for the given account holder name");
//        }
//    }

	}
    

