package com.ness.spn.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ness.spn.banking.exceptions.CreditCardAlreadyExistException;
import com.ness.spn.banking.exceptions.CreditCardNotFoundException;
import com.ness.spn.banking.model.CreditCard;
import com.ness.spn.banking.model.CreditCardRequest;
import com.ness.spn.banking.service.CreditCardService;

import io.jsonwebtoken.Jwts;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/creditcard")
public class CreditCardController {

	@Autowired
	private CreditCardService service;

	@PostMapping("/save")
	public ResponseEntity<?> saveCreditCard(@RequestBody CreditCardRequest card) {
		try {
			CreditCard creditCard = service.saveCreditCard(card);
			return new ResponseEntity<>("saved successfully", HttpStatus.CREATED);
		} catch (CreditCardAlreadyExistException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}

	}
	
	
	@GetMapping("/cards/{email}")
	public ResponseEntity<?> getCreditCardByCustomerId(@PathVariable("email") String email) {
		
		try { 
			CreditCard creditCard = service.getByEmail(email);
			return new ResponseEntity<>(creditCard, HttpStatus.OK);
		} catch (CreditCardNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/cards")
	public ResponseEntity<?> getAllCreditCard() {
		
			List<CreditCard> creditCard = service.getAllCreditCard();
			if(creditCard!=null) {
			return new ResponseEntity<>(creditCard, HttpStatus.OK);}
			
		 else { 
			return new ResponseEntity<>("failed to fetch all credit cards", HttpStatus.CONFLICT);
		 }
	}
	
	
	
	
	
	

}
