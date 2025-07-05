package com.ness.spn.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ness.spn.banking.model.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	@Query(value="SELECT * FROM CREDITCARD WHERE email=?1",nativeQuery = true)
	CreditCard findAllByEmail(String email);
}
