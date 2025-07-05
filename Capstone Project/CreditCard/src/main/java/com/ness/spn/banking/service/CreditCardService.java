package com.ness.spn.banking.service;

import java.util.List;

import com.ness.spn.banking.exceptions.CreditCardAlreadyExistException;
import com.ness.spn.banking.exceptions.CreditCardNotFoundException;

import com.ness.spn.banking.model.CreditCard;
import com.ness.spn.banking.model.CreditCardRequest;

public interface CreditCardService {

	public CreditCard saveCreditCard(CreditCardRequest card)throws CreditCardAlreadyExistException;
    CreditCard getByEmail(String email) throws CreditCardNotFoundException;
  
    List<CreditCard> getAllCreditCard();
}
