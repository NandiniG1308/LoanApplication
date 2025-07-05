package com.ness.loanapp.repo;

import org.springframework.data.jdbc.repository.query.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ness.loanapp.models.Loan;


@Repository
public interface LoanRepository extends JpaRepository<Loan,Long>{

	
	boolean existsByLoanId(long loanid);
	
	
	@Query("select l from Loan l where l.id=?1")
	Loan findByLoanId(long loanid);

}
