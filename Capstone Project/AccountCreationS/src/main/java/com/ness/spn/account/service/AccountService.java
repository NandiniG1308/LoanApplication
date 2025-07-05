package com.ness.spn.account.service;

import java.util.List;

import javax.security.auth.login.AccountException;

import com.ness.spn.account.exception.AccountAlreadyExistException;
import com.ness.spn.account.exception.AccountNotFoundException;
import com.ness.spn.account.model.Account;
import com.ness.spn.account.model.AccountRequest;

public interface AccountService {
	public boolean isAccountPresent(Long accountNumber);
	public Account getAccountById(Long accountNumber)throws AccountNotFoundException;
	public List<Account> getAccounts();
	public Double getBalanceByAccountHolderName(String accountHolderName) throws AccountNotFoundException;
	public Account addAccount(AccountRequest account) throws AccountAlreadyExistException;
    public Account deposit(Long accountNumber, double amount) throws AccountException;
    public Account withdraw(Long accountNumber, double amount) throws AccountException;
    public List<Account> getAccountsByEmail(String email);
    public boolean validate(String emailId);
}

