package com.ness.spn.account.model;

import org.springframework.web.bind.annotation.GetMapping;

import com.ness.spn.account.service.AccountServiceImpl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity(name = "account")
public class Account {
	
	@Id
//	@Column(name = "account_number")
//	@GeneratedValue
//	@Column(columnDefinition = "varchar(12)")
	private Long accountNumber;

//	@Column(name = "account_name")
	private String accountType;
	private String accountHolderName;
	private String accountHolderLastName;
	private String gender;
	private String email;
	private String branchName;
	private String ifscCode;
	private String phoneNumber;
	private String address;
	private double amount;
	private String adharNumber;
	private String panCardNumber;
	private double balance=0.0;
	
	public Account() {
		super();
	}

	public Account(Long accountNumber, String accountType, String accountHolderName, String accountHolderLastName,
			String gender, String email, String branchName, String ifscCode, String phoneNumber, String address,
			double amount, String adharNumber, String panCardNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountHolderLastName = accountHolderLastName;
		this.gender = gender;
		this.email = email;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.amount = amount;
		this.adharNumber = adharNumber;
		this.panCardNumber = panCardNumber;
		this.balance = balance;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAccountHolderLastName() {
		return accountHolderLastName;
	}

	public void setAccountHolderLastName(String accountHolderLastName) {
		this.accountHolderLastName = accountHolderLastName;
	}

	public String getAdharNumber() {
		return adharNumber;
	}


	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}


	public String getPanCardNumber() {
		return panCardNumber;
	}


	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}


	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
