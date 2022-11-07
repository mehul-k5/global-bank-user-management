package com.example.bankusermanagementbackend.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankusermanagementbackend.model.loan_details;

@Repository
public interface Loan_detailsDao extends JpaRepository<loan_details,String> {

}
