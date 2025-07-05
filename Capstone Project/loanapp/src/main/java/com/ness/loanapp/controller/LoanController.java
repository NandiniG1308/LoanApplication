package com.ness.loanapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ness.loanapp.exceptions.LoanNotFoundException;
import com.ness.loanapp.models.Loan;

import com.ness.loanapp.services.LoanService;

@Controller
@RequestMapping("api/v1")
@CrossOrigin
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	
	// This is Post Operation
	@PostMapping
	public ResponseEntity<Loan> applyLoan(@RequestBody Loan loan) {
		return new ResponseEntity<Loan>(loanService.applyLoan(loan), HttpStatus.OK);
	}
	
	
	// This is Get Operation 
	@GetMapping(path = "/get/{loanId}")
	public ResponseEntity<?> getCardById(@PathVariable("loanId") long loanId){
	    Loan fetchloan = null;
	    try {
	        fetchloan = (Loan) loanService.getLoansByLoanId(loanId);
	    } catch (LoanNotFoundException e) {
	        return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<Loan>(fetchloan, HttpStatus.OK);
	}
	
	
	@PutMapping("/deposit/{loanId}/{Amount}")
    public ResponseEntity<?> deposit(@PathVariable("loanId") long loanId, @PathVariable("Amount") double amount)  {
		Loan loan = new Loan();
		Loan deposit;
		try {
			deposit = loanService.deposit(loanId,amount);
			
			return new ResponseEntity<String>("depositted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("failed to deposit",HttpStatus.CONFLICT);
		}
    	

    }

    
}
