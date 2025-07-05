package com.ness.spn.banking.model;



import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Creditcard")
public class CreditCard {

	@Id
	private Long cardNumber;
	private String email;
	private String cardType;
	private int expMonth;
	private int expYear;
	private int cvv;
	private Double creditLimit;
	private String cardHolderName;




	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public CreditCard(Long cardNumber, String email, String cardType, int expMonth, int expYear,
			int cvv, Double creditLimit, String cardHolderName) {
		super();
		this.cardNumber = cardNumber;
		this.email = email;
		this.cardType = cardType;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.cvv = cvv;
		this.creditLimit = creditLimit;
		this.cardHolderName = cardHolderName;
	}

	public CreditCard() {
		super();
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

}