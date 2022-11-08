package com.example.bankusermanagementbackend.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankusermanagementbackend.model.LoanId;
import com.example.bankusermanagementbackend.model.LoanDetails;

@Repository
public interface Loan_detailsDao extends JpaRepository<LoanDetails,LoanId> {

}
