package com.example.bankusermanagementbackend.Dao;

import java.util.List;
import java.sql.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankusermanagementbackend.model.TransactionDetails;


@Repository
public interface transaction_detailsDao extends JpaRepository<TransactionDetails,String>{
	@Query(value = "SELECT * FROM transaction_details td where td.account_number = :account_number and td.date_of_transaction >= :fromDate and td.date_of_transaction <= :toDate", nativeQuery = true)
	List<TransactionDetails> getAllTransactionsbetweenDates(@Param("account_number") String account_number, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value = "SELECT * FROM transaction_details td where td.account_number = :account_number and td.transaction_type = :transaction_type and td.date_of_transaction >= :fromDate and td.date_of_transaction <= :toDate", nativeQuery = true)
	List<TransactionDetails> getTypeofTransactionsbetweenDates(@Param("account_number") String account_number, @Param("transaction_type") String transaction_type, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
