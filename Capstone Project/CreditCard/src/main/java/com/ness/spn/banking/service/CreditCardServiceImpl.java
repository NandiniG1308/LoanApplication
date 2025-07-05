package com.ness.spn.banking.service;

import java.util.List;
import java.time.LocalDate;
import java.time.YearMonth;

import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ness.spn.banking.exceptions.CreditCardAlreadyExistException;
import com.ness.spn.banking.exceptions.CreditCardNotFoundException;
import com.ness.spn.banking.model.CreditCard;
import com.ness.spn.banking.model.CreditCardRequest;
import com.ness.spn.banking.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardRepository cardRepository;

	@Override
	public CreditCard saveCreditCard(CreditCardRequest card) throws CreditCardAlreadyExistException {
		CreditCard existCard = new CreditCard();
		
		existCard.setCardNumber(generateCardNumber());
		existCard.setExpYear(generateRandomYear(2020,2027));
		existCard.setExpMonth(generateRandomMonth(1,12));
		existCard.setCardHolderName(card.getCardHolderName());
		existCard.setCardType(card.getCardType());
		existCard.setCreditLimit(card.getCreditLimit());
		existCard.setCvv(generateRandomNumber());
		existCard.setEmail(card.getEmail());
		
	
		CreditCard currentCard = cardRepository.save(existCard);
		if (currentCard == null) {
			throw new CreditCardAlreadyExistException("card alreday exists");
		}
		return currentCard;

	}

	@Override
	public CreditCard getByEmail(String email) throws CreditCardNotFoundException {
		CreditCard card = cardRepository.findAllByEmail(email);
		if (card == null) {
			throw new CreditCardNotFoundException("card not found");
		}
		return card;
	}

	public Long generateCardNumber() {
		long min = 100_000_000_000L; // Minimum 12-digit number
		long max = 999_999_999_999L; // Maximum 12-digit number
		long generatedNumber = min + (long) (Math.random() * (max - min));
		return Long.valueOf(generatedNumber);
	}

	 public static int generateRandomYear(int startYear, int endYear) {
	        Random random = new Random();
	        return random.nextInt(endYear - startYear + 1) + startYear;
	    }
	 
	 public static int generateRandomMonth(int startMonth, int endMonth) {
	        Random random = new Random();
	        return random.nextInt(endMonth - startMonth + 1) + startMonth;
	    }

	@Override
	public List<CreditCard> getAllCreditCard() {
		
		return cardRepository.findAll();
	}

	 public int generateRandomNumber() {
	        Random random = new Random();
	        return random.nextInt(900) + 100; 
	    }
	

	
}
