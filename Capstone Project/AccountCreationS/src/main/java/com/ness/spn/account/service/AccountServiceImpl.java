package com.ness.spn.account.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ness.spn.account.exception.AccountAlreadyExistException;
import com.ness.spn.account.exception.AccountNotFoundException;
import com.ness.spn.account.model.Account;
import com.ness.spn.account.model.AccountRequest;
import com.ness.spn.account.repository.AccountRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository repository;
	

	@Override
	public boolean isAccountPresent(Long accountNumber) {
		return repository.existsById(accountNumber);
	}
	@Override
	public Account getAccountById(Long accountNumber)throws AccountNotFoundException {
		Optional<Account> optionalAccount = repository.findById(accountNumber);
	    
	    if (optionalAccount.isEmpty()) {
	        throw new AccountNotFoundException("Account not found");
	    }
	    
	    return optionalAccount.get();
}
	@Override
	public List<Account> getAccounts() {
		List<Account> accounts = new ArrayList<>();
		Iterator<Account> accountIterator = repository.findAll().iterator();
		while (accountIterator.hasNext()) {
			accounts.add(accountIterator.next());
		}
		return accounts;
	}
	
	@Override
	public Account addAccount(AccountRequest account) throws AccountAlreadyExistException {
		  Account savedAccount=new Account();
		
//	        if(repository.existsById(account.getAccountHolderName())){
//	            throw new AccountAlreadyExistException("User with ID "+account.getAccountNumber()+" already exists");
//	        }
//	        else{
	        	
	        	Long accountNumber1 = generateAccountNumber();
	        	savedAccount.setIfscCode(generateIfscCode());
	        	savedAccount.setAccountNumber(accountNumber1);
	        	savedAccount.setGender(account.getGender());
	        	savedAccount.setAccountHolderLastName(account.getAccountHolderLastName());
	        	savedAccount.setAdharNumber(account.getAdharNumber());
	        	savedAccount.setPanCardNumber(account.getPanCardNumber());
	        	savedAccount.setAccountHolderName(account.getAccountHolderName());
	        	savedAccount.setAccountType(account.getAccountType());
	        	savedAccount.setAddress(account.getAddress());
	        	savedAccount.setEmail(account.getEmail());
	        	savedAccount.setPhoneNumber(account.getPhoneNumber());
	        	savedAccount.setBranchName(account.getBranchName());
	        	savedAccount.setBalance(account.getBalance());
	        	savedAccount.setAmount(account.getAmount());
	        	
//	            user.setUserAddedDate(new Date());
	            savedAccount=repository.save(savedAccount);
//	            if (savedAccount==null){
//	                throw new AccountAlreadyExistException("User with ID "+account.getAccountNumber()+" already exists");
//	            }
	        
	        return savedAccount;
		
		
	}
	private Long generateAccountNumber() {
        
        long min = 100_000_000_000L; // Minimum 12-digit number
        long max = 999_999_999_999L; // Maximum 12-digit number
        long generatedNumber = min + (long) (Math.random() * (max - min));

        return Long.valueOf(generatedNumber);
    }
	
//	@Override
//	public Double getBalanceByAccountHolderName(String accountHolderName) throws AccountNotFoundException {
//       Optional<Account> optionalAccount = repository.findByAccountHolderName(accountHolderName);
//        if (optionalAccount.isPresent()) {
//            Account account = optionalAccount.get();
//           return account.getBalance();
//       } else {
//           throw new AccountNotFoundException("Account not found for the given account holder name");
//       }
//   }
	 public double getBalanceByAccountNumber(Long accountNumber) throws Exception{
	        Account bankAccount = repository.findByAccountNumber(accountNumber);
	        if (bankAccount != null) {
	            return bankAccount.getBalance();
	        }
	        throw new Exception("Bank account not found with account number: " + accountNumber);
	    }
	
	
		@Override
	   @Transactional
	    public Account deposit(Long accountNumber, double amount) throws AccountException {
	        Account account = repository.findById(accountNumber)
	                .orElseThrow(() -> new AccountException("Account not found"));

	        double newBalance = account.getBalance() + amount;
	        account.setBalance(newBalance);

	        return account;
	    }
		@Override
	    @Transactional
	    public Account withdraw(Long accountNumber, double amount) throws AccountException {
	        Account account = repository.findById(accountNumber)
	                .orElseThrow(() -> new AccountException("Account not found"));

	        if (account.getBalance() < amount) {
	            throw new AccountException("Insufficient balance");
	        }

	        double newBalance = account.getBalance() - amount;
	        account.setBalance(newBalance);

	        return account;
	    }
		@Override
	 public List<Account> getAccountsByEmail(String email) {
	        return repository.findAllByEmail(email);
	    }

	 
	 public String generateIfscCode() {
		        // Logic to generate IFSC code based on branch name
		        // Example: IFSC code = first four characters of branch name in uppercase
		        return "SPNB0009591";
		}
	@Override
	public boolean validate(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Double getBalanceByAccountHolderName(String accountHolderName) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	 

}


