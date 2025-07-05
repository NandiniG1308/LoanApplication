package com.ness.spn.account.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.ness.spn.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>  {
	List<Account> findAllByEmail(String email);

	Optional<Account> findByAccountHolderName(String accountHolderName);

	

	

	Account findByAccountNumber(Long accountNumber);

	

}
