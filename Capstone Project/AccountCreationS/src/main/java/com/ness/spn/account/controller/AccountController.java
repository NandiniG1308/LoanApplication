package com.ness.spn.account.controller;

import java.util.List;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ness.spn.account.exception.AccountAlreadyExistException;
import com.ness.spn.account.exception.AccountNotFoundException;
import com.ness.spn.account.model.Account;
import com.ness.spn.account.model.AccountRequest;
import com.ness.spn.account.repository.AccountRepository;
import com.ness.spn.account.service.AccountServiceImpl;

@RequestMapping("/api/v1")
@Controller
@CrossOrigin("*")
public class AccountController {
	
	@Autowired
	private AccountServiceImpl service;

	@RequestMapping(path = "/account/{accountNumber}", method = RequestMethod.GET)
	public ResponseEntity<?> getAccountById(@PathVariable("accountNumber") Long accountNumber) {
		  try {
              Account fetchedUser = service.getAccountById(accountNumber);
              return new ResponseEntity<Account>(fetchedUser,HttpStatus.OK);
          }catch (AccountNotFoundException e){
              return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
          }
	}
	
	

	@RequestMapping(path = "/getAccounts", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getAccounts() {
		return ResponseEntity.ok(service.getAccounts());
	}

	@RequestMapping(path = "/createAccount", method = RequestMethod.POST)
	public ResponseEntity<?> addAccount(@RequestBody AccountRequest account ) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(service.addAccount(account));
		  try {
              Account addAccount = service.addAccount(account);
              return new ResponseEntity<Account>(addAccount, HttpStatus.CREATED);
          } catch (AccountAlreadyExistException e) {
              return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
          }
		
	}
//	 @GetMapping("/balance/{accountHolderName}")
//	    public ResponseEntity<Double> getBalanceByAccountHolderName(@PathVariable("accountHolderName") String accountHolderName) {
//	        try {
//	            Double balance = service.getBalanceByAccountHolderName(accountHolderName);
//	            return ResponseEntity.ok(balance);
//	        } catch (AccountNotFoundException e) {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
	@GetMapping("/{accountNumber}/balance")
    public ResponseEntity<Double> getBalanceByAccountNumber(@PathVariable Long accountNumber) throws Exception {
        double balance = service.getBalanceByAccountNumber(accountNumber);
        return ResponseEntity.ok(balance);
    }
	
	@GetMapping("/email/{emailId}")
	    public ResponseEntity<List<Account>> getAccountsByAccountHolderName(@PathVariable("emailId") String emailId) {
		List<Account> accounts=service.getAccountsByEmail(emailId);
	        return new ResponseEntity<List<Account>> (accounts, HttpStatus.OK);
	    }

	
//    @PutMapping("/{accountNumber}/deposite/{amount}")
//    public ResponseEntity<?> deposit(@PathVariable ("accountNumber") Long accountNumber, @PathVariable ("amount") double amount) throws AccountException {
//    	
//    	Account deposit=service.deposit(accountNumber, amount);
//    	if(deposit!=null) {
//    		return new ResponseEntity<String>("depositted",HttpStatus.OK);
//    	}else {
//    		return new ResponseEntity<String>("failed to deposit",HttpStatus.CONFLICT);
//    	}
//    }
	
	@PutMapping("/{accountNumber}/deposite/{amount}")
	public ResponseEntity<?> deposit(@PathVariable("accountNumber") Long accountNumber, @PathVariable("amount") double amount) throws AccountException {
	    Account deposit = service.deposit(accountNumber, amount);
	    if (deposit != null) {
	        return ResponseEntity.ok().build();
	    } else {
	        return ResponseEntity.status(HttpStatus.CONFLICT).build();
	    }
	}


//    @PutMapping("/{accountNumber}/withdraw/{amount}")
//    public ResponseEntity<?> withdraw(@PathVariable("accountNumber") Long accountNumber, @PathVariable("amount") double amount) throws AccountException {
//        
//        Account withdraw=service.withdraw(accountNumber, amount);
//    	if(withdraw!=null) {
//    		return new ResponseEntity<String>("withdrawed",HttpStatus.OK);
//    	}else {
//    		return new ResponseEntity<String>("failed to deposit",HttpStatus.CONFLICT);
//    	}
//    }
	
	
  @PutMapping("/{accountNumber}/withdraw/{amount}")
  public ResponseEntity<?> withdraw(@PathVariable("accountNumber") Long accountNumber, @PathVariable("amount") double amount) throws AccountException {
      
      Account withdraw=service.withdraw(accountNumber, amount);
  	if(withdraw!=null) {
  		 return ResponseEntity.ok().build();
  	}else {
  		 return ResponseEntity.status(HttpStatus.CONFLICT).build();
  	}
  }
	
    
       
 
   
}
